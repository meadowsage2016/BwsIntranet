package edu.matc.entity;

import edu.matc.persistence.CylinderOptionsDao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(
        name = "cylinderOptionsSearch",
        urlPatterns = { "/CylinderOptionsSearch" }
)
/**
 * Created by Sue Hundt on 2/24/17.
 */
public class CylinderOptionsServlet  extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        CylinderOptionsDao cylinder = new CylinderOptionsDao();

        CylinderOptions result = null;
        List<CylinderOptions> results = new ArrayList<CylinderOptions>();

        // Get Searchtype and Searchword submitted from form
        String searchType  = request.getParameter("selectCylinderOptionsSearchType");
        String gasNumber = request.getParameter("searchByGasNumber");

        //  Take updated Search object and store in Sessio
        HttpSession  sessionCyl      = request.getSession();
        sessionCyl.setAttribute("noRecordsFoundMessage", "");

//        if(searchType == "1") {

            results = cylinder.getAllCylOptions();

/**            if (results.isEmpty()) {
                session.setAttribute("noRecordsFoundMessage", "No records found for search City entered.");
            }
            else {
*/
                sessionCyl.setAttribute("SearchResults", results);
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
        String url =  "/cylinderOptionsJSP.jsp";

        // Forward the request header to the JSP page
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}