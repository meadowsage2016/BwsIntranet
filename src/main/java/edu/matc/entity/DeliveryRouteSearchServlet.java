package edu.matc.entity;

import edu.matc.persistence.DeliveryRouteDao;

import java.io.*;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(
        name = "deliveryRouteSearch",
        urlPatterns = { "/DeliveryRouteSearch" }
)
/**
 * Created by Susan Hundt on 2/24/17.
 */
public class DeliveryRouteSearchServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DeliveryRouteDao route = new DeliveryRouteDao();

        List<DeliveryRoute> results;

        HttpSession  sessionDel      = request.getSession();

        results = route.getAllDeliveryRoutes();
        if (results.isEmpty()) {
            sessionDel.setAttribute("noRecordsFoundMessage", "No records found for search City entered.");
        }
        else {

            sessionDel.setAttribute("SearchResults", results);
        }

      // Local variable to hold url of results page
        String url =  "/deliveryRoutesJSP.jsp";

        // Forward the request header to the JSP page
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}