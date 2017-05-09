package edu.matc.maintenance;

import edu.matc.entity.CylinderOptions;
import edu.matc.entity.DeliveryRoute;
import edu.matc.persistence.CylinderOptionsDao;
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
 * DeliveryRoutesDeleteServlet takes code passed from deleteDeliveryRoutesSelectJSP and attempts
 * to 1) (doGet) retrieve the data for that record for user to verify delete and
 * 2) (doPost) delete the record from data base
 *
 * The BwsIntranet program produces a website for internal use of BWS employees
 *
 * @author Sue Hundt
 * @version 1.0
 * @since   2017-02-12
 */
@WebServlet(
        name = "DeliveryRoutesDelete",
        urlPatterns = { "/DeliveryRoutesDelete" }
)
public class DeliveryRoutesDeleteServlet extends HttpServlet  {

    static Logger log = Logger.getLogger(DeliveryRoutesDeleteServlet.class.getName());

    /**
     * doGet attempts to retrieve the record to be deleted via the keyword passed from
     * the deleteDeliveryRoutesSelectJSP, if record is not found, notification is sent to user
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
        HttpSession sessionDelete = request.getSession();
        String paramValue = request.getParameter("city");

        // retrieve record from database
        route = dao.getDeliveryRouteByCityOrBusiness(paramValue);

        // if not found, notify user, else send data
        if (route == null) {

            sessionDelete.setAttribute("Message", "City or Business not found: " + paramValue);
            log.warn("City or Business not found: " + paramValue);
            // Local variable to hold url of results page
            url = "/maintenanceJSPs/deleteDeliveryRoutesSelectJSP.jsp";

        } else {

            routeAsList.add(route);

            sessionDelete.setAttribute("DeleteResult", routeAsList);
            sessionDelete.setAttribute("Message", "");
            // Local variable to hold url of results page
            url = "/maintenanceJSPs/deleteDeliveryRoutesJSP.jsp";

        }

        // Forward the request header to the JSP page
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    /**
     * doPost performs the delete of the verified record
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
        public void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            // Local variables
            String message = "Delete not Successful";
            int id = 0;

            // Local instances
            DeliveryRoute route = new DeliveryRoute();
            DeliveryRouteDao dao = new DeliveryRouteDao();

            //  get session and parameter with keyword
            HttpSession sessionDelete = request.getSession();
            String routeToDelete = request.getParameter("city");

            // get Id of record to delete
            route = dao.getDeliveryRouteByCityOrBusiness(routeToDelete);
            int routeIdToDelete = route.getDeliveryRouteId();

            try {
                dao.deleteDeliveryRoute(routeIdToDelete);
                message="Successful delete of : " + routeToDelete;
                log.info(message);
                sessionDelete.setAttribute("Message", message);
                // Local variable to hold url of results page
                String url = "/maintenanceJSPs/deleteDeliveryRoutesSelectJSP.jsp";

                // Forward the request header to the JSP page
                RequestDispatcher dispatcher
                        = getServletContext().getRequestDispatcher(url);
                dispatcher.forward(request, response);

            } catch (Exception ex) {
                log("Exception thrown trying to delete Delivery Route: " + ex);
            }

        }
    }
