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

        DeliveryRouteDao dao = new DeliveryRouteDao();

        List<DeliveryRoute> results = new ArrayList<DeliveryRoute>();

        //  Take updated Search object and store in Sessio
        HttpSession sessionAdd = request.getSession();
        String paramValue = request.getParameter("maintType");

        route.setDeliveryCityOrBusiness(request.getParameter("city"));
        route.setDeliveryDay(request.getParameter("day"));
        route.setDeliveryFrequency(request.getParameter("frequency"));


        id = dao.addDeliveryRoute(route);

        System.out.println("Route id returned: " + id );

        if (id == 0) {
            sessionAdd.setAttribute("Message", message);
        } else {
            newRoute = dao.getDeliveryRouteById(id);
            message = "Successful Add: ";
            results.add(newRoute);

            sessionAdd.setAttribute("MaintResult", results);
            sessionAdd.setAttribute("Message", message);
        }



        // Local variable to hold url of results page
        String url = "/newDeliveryRouteJSP.jsp";

// Forward the request header to the JSP page
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }
}
