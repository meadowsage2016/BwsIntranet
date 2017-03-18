package edu.matc.entity;

import edu.matc.persistence.CitiesByZipDao;
import edu.matc.persistence.CylinderOptionsDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sue Hundt on 3/16/17.
 */
public class CitiesByZipMaintServlet extends HttpServlet { public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    CitiesByZipDao city = new CitiesByZipDao();

    CitiesByZip result = null;
    List<CitiesByZip> results = new ArrayList<CitiesByZip>();

    //  Take updated Search object and store in Sessio
    HttpSession sessionCity      = request.getSession();
    sessionCity.setAttribute("noRecordsFoundMessage", "");

    String paramName = "zipCode";
    String paramValue = request.getParameter(paramName);
    results = city.getCityByZip(paramValue);
    sessionCity.setAttribute("SearchResults", results);

    // Local variable to hold url of results page
    String url =  "/citiesByZipMaintJSP.jsp";

    // Forward the request header to the JSP page
    RequestDispatcher dispatcher
            = getServletContext().getRequestDispatcher(url);
    dispatcher.forward(request, response);
}
}