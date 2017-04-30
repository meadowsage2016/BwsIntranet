package edu.matc.searches;

import edu.matc.entity.CylinderOptions;
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
public class CylinderOptionsSearchServlet  extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        CylinderOptionsDao cylinder = new CylinderOptionsDao();

        CylinderOptions result = null;
        List<CylinderOptions> results = new ArrayList<CylinderOptions>();

        //  Take updated Search object and store in Sessio
        HttpSession  sessionCyl      = request.getSession();
        sessionCyl.setAttribute("noRecordsFoundMessage", "");


        results = cylinder.getAllCylOptions();
        sessionCyl.setAttribute("SearchResults", results);

        // Local variable to hold url of results page
        String url =  "/cylinderOptionsJSP.jsp";

        // Forward the request header to the JSP page
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}