package edu.matc.maintenance;

import edu.matc.entity.CylinderOptions;
import edu.matc.entity.DeliveryRoute;
import edu.matc.persistence.CylinderOptionsDao;
import edu.matc.persistence.DeliveryRouteDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * Created by student on 4/29/17.
 */
@WebServlet(
        name = "DeliveryRoutesDelete",
        urlPatterns = { "/DeliveryRoutesDelete" }
)
public class DeliverRoutesDeleteServlet extends HttpServlet  {

        public void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            String message = "Delete not Successful";
            int id = 0;

            DeliveryRoute route = new DeliveryRoute();
            DeliveryRouteDao dao = new DeliveryRouteDao();

            //  Take updated Search object and store in Session
            HttpSession sessionDelete = request.getSession();
            String routeToDelete = request.getParameter("city");

            route = dao.getDeliveryRouteByCityOrBusiness(routeToDelete);
            int routeIdToDelete = route.getDeliveryRouteId();

            try {
                dao.deleteDeliveryRoute(routeIdToDelete);
                message="Successful delete.";
                sessionDelete.setAttribute("Message", message);
                // Local variable to hold url of results page
                String url = "/deleteDeliveryRoutesJSP.jsp";

                // Forward the request header to the JSP page
                RequestDispatcher dispatcher
                        = getServletContext().getRequestDispatcher(url);
                dispatcher.forward(request, response);

            } catch (Exception ex) {
            }

        }
    }