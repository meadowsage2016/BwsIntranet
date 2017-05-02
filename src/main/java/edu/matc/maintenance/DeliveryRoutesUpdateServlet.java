package edu.matc.maintenance;

import edu.matc.entity.DeliveryRoute;
import edu.matc.persistence.DeliveryRouteDao;

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
     * Created by student on 4/29/17.
     */
    @WebServlet(
            name = "DeliveryRoutesUpdate",
            urlPatterns = { "/DeliveryRoutesUpdate" }
    )
    public class DeliveryRoutesUpdateServlet extends HttpServlet {

        public void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            List<DeliveryRoute> routeAsList = new ArrayList<DeliveryRoute>();
            DeliveryRoute route = new DeliveryRoute();
            DeliveryRouteDao dao = new DeliveryRouteDao();

            //  Take updated Search object and store in Sessio
            HttpSession sessionAdd = request.getSession();
            String paramValue = request.getParameter("city");

            route = dao.getDeliveryRouteByCityOrBusiness(paramValue);
            routeAsList.add(route);

            sessionAdd.setAttribute("UpdateResult", routeAsList);
            sessionAdd.setAttribute("Message", "");

            // Local variable to hold url of results page
            String url = "/maintenanceJSPs/updateDeliveryRoutesJSP.jsp";

            // Forward the request header to the JSP page
            RequestDispatcher dispatcher
                    = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);

        }

        public void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            String message = "Update NOT Successful, see log file";
            String deliveryRouteIdUpdate;
            String deliveryCityOrBusinessUpdate;
            String deliveryFrequencyUpdate;
            String deliveryDayUpdate;

            DeliveryRoute route;

            DeliveryRouteDao dao = new DeliveryRouteDao();

            //  Take updated Search object and store in Sessio
            HttpSession sessionAdd = request.getSession();

            deliveryRouteIdUpdate = request.getParameter("cityId");
            deliveryCityOrBusinessUpdate = request.getParameter("city");
            deliveryFrequencyUpdate = request.getParameter("frequency");
            deliveryDayUpdate = request.getParameter("day");

            int routeId = Integer.parseInt("deliveryRouteIdUpdate");

            route = dao.getDeliveryRouteById(routeId);

            route.setDeliveryFrequency(deliveryFrequencyUpdate);
            route.setDeliveryDay(deliveryDayUpdate);

            try {
                dao.updateDeliveryRoute(route);
                message = "Update Successful";
                sessionAdd.setAttribute("Message", message);
            } catch (Exception ex) {
                sessionAdd.setAttribute("Message", message);
            }

            // Local variable to hold url of results page
            String url = "/maintenanceJSPs/updateDeliveryRoutesSelectJSP.jsp";

            // Forward the request header to the JSP page
            RequestDispatcher dispatcher
                    = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);

        }
    }


