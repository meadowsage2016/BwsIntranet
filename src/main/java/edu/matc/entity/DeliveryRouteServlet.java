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
public class DeliveryRouteServlet  extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DeliveryRouteDao route = new DeliveryRouteDao();

        // Get Searchtype and Searchword submitted from form
        String searchType  = request.getParameter("selectDeliveryRouteType");
        System.out.println("searchtype: " + searchType);
        //String city = request.getParameter("searchCity"
        //
        // Set Search object variables

        List<DeliveryRoute> results;
//        DeliveryRoute result = new DeliveryRoute();
        //  Take updated Search object and store in Sessio
        HttpSession  sessionDel      = request.getSession();


//        if(searchType == "1") {
            System.out.println("IM in here");

            results = route.getAllDeliveryRoutes();
            if (results.isEmpty()) {
                sessionDel.setAttribute("noRecordsFoundMessage", "No records found for search City entered.");
            }
            else {

                sessionDel.setAttribute("SearchResults", results);
            }
/**
        }
       if(searchType == "2") {
           result = route.getDeliveryRouteByCityOrBusiness(city);
           if (result == null) {
                session.setAttribute("noRecordsFoundMessage", "No record found for search City entered.");
            } else {
               session.setAttribute("SearchResults", result);
            }
        }
 */       // Local variable to hold url of results page
        String url =  "/deliveryRoutesJSP.jsp";

        // Forward the request header to the JSP page
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}