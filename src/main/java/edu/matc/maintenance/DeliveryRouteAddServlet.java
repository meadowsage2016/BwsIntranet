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
        name = "DeliveryRouteAdd",
        urlPatterns = { "/DeliveryRouteAdd" }
)
public class DeliveryRouteAddServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String message = "Add not Successful";
        int id = 0;

        DeliveryRoute route = new DeliveryRoute();
        DeliveryRoute newRoute = new DeliveryRoute();
        DeliveryRoute duplicateRoute = new DeliveryRoute();

        DeliveryRouteDao dao = new DeliveryRouteDao();

        List<DeliveryRoute> results = new ArrayList<DeliveryRoute>();

        //  Take updated Search object and store in Sessio
        HttpSession sessionAdd = request.getSession();

        String newCityOrBusiness = request.getParameter("city");

        duplicateRoute =  dao.getDeliveryRouteByCityOrBusiness(newCityOrBusiness);

        if (duplicateRoute == null) {

            route.setDeliveryCityOrBusiness(request.getParameter("city"));
            route.setDeliveryDay(request.getParameter("day"));
            route.setDeliveryFrequency(request.getParameter("frequency"));

            try {
                id = dao.addDeliveryRoute(route);
            } catch (Exception ex) {
                log("Exception found trying to add new Route :" + ex);
            }

            if (id == 0) {
                sessionAdd.setAttribute("Message", message);
            } else {
                newRoute = dao.getDeliveryRouteById(id);
                message = "Successful Add: " + newCityOrBusiness;
                results.add(newRoute);

                sessionAdd.setAttribute("MaintResult", results);
                sessionAdd.setAttribute("Message", message);
            }
        } else {
            message = "City or Business already exists for: " + duplicateRoute;
            sessionAdd.setAttribute("Message", message);
        }

        // Local variable to hold url of results page
        String url = "/maintenanceJSPs/newDeliveryRouteJSP.jsp";

        // Forward the request header to the JSP page
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }
}
