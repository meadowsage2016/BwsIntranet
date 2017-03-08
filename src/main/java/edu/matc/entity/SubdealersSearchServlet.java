package edu.matc.entity;

import edu.matc.persistence.CylinderOptionsDao;
import edu.matc.persistence.SubdealersDao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(
        name = "subdealersSearch",
        urlPatterns = { "/SubdealerSearch" }
)
/**
 * Created by student on 2/24/17.
 */
public class SubdealersSearchServlet  extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        SubdealersDao subdealer = new SubdealersDao();

        Subdealers result = null;
        List<Subdealers> results = new ArrayList<Subdealers>();

        // Get Searchtype and Searchword submitted from form
        String searchType  = request.getParameter("subdealerSearchType");
        String county = request.getParameter("county");

        //  Take updated Search object and store in Sessio
        HttpSession  sessionSub      = request.getSession();
        sessionSub.setAttribute("noRecordsFoundMessage", "");

//        if(searchType == "1") {

        results = subdealer.getAllSubdealers();

/**            if (results.isEmpty()) {
 session.setAttribute("noRecordsFoundMessage", "No records found for search City entered.");
 }
 else {
 */
        sessionSub.setAttribute("SearchResults", results);
/**            }

 }

 if(searchType == "2") {

 result = cylinder.getCylOptionByGasNumber(gasNumber);


 if (result == null) {
 session.setAttribute("noRecordsFoundMessage", "No record found for search City entered.");
 } else {

 session.setAttribute("SearchResults", result);
 }
 }
 */

        // Local variable to hold url of results page
        String url =  "/subdealersJSP.jsp";

        // Forward the request header to the JSP page
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}