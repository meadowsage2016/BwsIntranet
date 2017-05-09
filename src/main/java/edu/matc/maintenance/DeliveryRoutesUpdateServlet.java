package edu.matc.maintenance;

import edu.matc.entity.DeliveryRoute;
import edu.matc.persistence.DeliveryRouteDao;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * DeliveryRoutesUpdateServlet takes code passed from updateDeliveryRouteJSP and attempts
 * to update the data base
 *
 * The BwsIntranet program produces a website for internal use of BWS employees
 *
 * @author Sue Hundt
 * @version 1.0
 * @since   2017-02-12
 */
    @WebServlet(
            name = "DeliveryRoutesUpdate",
            urlPatterns = { "/DeliveryRoutesUpdate" }
    )
    public class DeliveryRoutesUpdateServlet extends HttpServlet {

        static Logger log = Logger.getLogger(DeliveryRoutesUpdateServlet.class.getName());

    /**
     * doGet takes keyword sent from updateDeliveryRoutesSelectJSP, tries to return the data
     * for the record for update, else is notifies user that the record isn't found
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
        public void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            // Local variables
            String url = "";

            // Local instances
            List<DeliveryRoute> routeAsList = new ArrayList<DeliveryRoute>();
            DeliveryRoute route = new DeliveryRoute();
            DeliveryRouteDao dao = new DeliveryRouteDao();


            //  Get session and keyword from parameter
            HttpSession sessionAdd = request.getSession();
            String paramValue = request.getParameter("city");

            // retrieve the record from the data base
            route = dao.getDeliveryRouteByCityOrBusiness(paramValue);

            // If the record isn't found, notify user, else send record
            if (route == null) {

                sessionAdd.setAttribute("Message", "Delivery Route Not Found : " + paramValue);
                log.warn("Delivery Route Not Found : " + paramValue);

                // Local variable to hold url of results page
                url = "/maintenanceJSPs/updateDeliveryRoutesSelectJSP.jsp";

            } else {
                routeAsList.add(route);

                sessionAdd.setAttribute("UpdateResult", routeAsList);
                sessionAdd.setAttribute("Message", "");
                log.info("Delivery route record found for update");
                // Local variable to hold url of results page
                url = "/maintenanceJSPs/updateDeliveryRoutesJSP.jsp";
            }

            // Forward the request header to the JSP page
            RequestDispatcher dispatcher
                    = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);

        }

    /**
     * doPost takes updated data returned from updateDeliveryRoutesJSP and updates the data base
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
        public void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            // Local variable
            String message = "Update NOT Successful, see log file";
            String deliveryRouteIdUpdate;
            String deliveryCityOrBusinessUpdate;
            String deliveryFrequencyUpdate;
            String deliveryDayUpdate;

            // Local instances
            DeliveryRoute route;
            DeliveryRouteDao dao = new DeliveryRouteDao();

            //  Get session and updated data from parameters
            HttpSession sessionAdd = request.getSession();

            deliveryRouteIdUpdate = request.getParameter("cityId");
            deliveryCityOrBusinessUpdate = request.getParameter("city");
            deliveryFrequencyUpdate = request.getParameter("frequency");
            deliveryDayUpdate = request.getParameter("day");

            // convert string id to integer
            int routeId = Integer.parseInt(deliveryRouteIdUpdate);

            // get the delivery route record to update
            route = dao.getDeliveryRouteById(routeId);

            // set with new data from udpate
            route.setDeliveryFrequency(deliveryFrequencyUpdate);
            route.setDeliveryDay(deliveryDayUpdate);

            // update the record in the database, send message if not successful
            try {
                dao.updateDeliveryRoute(route);
                message = "Update Successful for: " + deliveryCityOrBusinessUpdate;
                sessionAdd.setAttribute("Message", message);
                log.info(message);

            } catch (Exception ex) {
                sessionAdd.setAttribute("Message", message);
                log("Exception thrown updating Delivery Route" + ex);
            }

            // Local variable to hold url of results page
            String url = "/maintenanceJSPs/updateDeliveryRoutesSelectJSP.jsp";

            // Forward the request header to the JSP page
            RequestDispatcher dispatcher
                    = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);

        }
    }


