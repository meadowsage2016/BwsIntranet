package edu.matc.searches;

import edu.matc.entity.CitiesByZip;
import edu.matc.persistence.CitiesByZipDao;

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
 * Created by student on 3/16/17.
 */
@WebServlet(
        name = "citiesByZipSearch",
        urlPatterns = { "/CitiesByZipSearch" }
)
public class CitiesByZipSearchServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        CitiesByZipDao city = new CitiesByZipDao();

        CitiesByZip result = null;
        List<CitiesByZip> results = new ArrayList<CitiesByZip>();

        //  Take updated Search object and store in Sessio
        HttpSession sessionCity      = request.getSession();
        sessionCity.setAttribute("noRecordsFoundMessage", "");


        results = city.getAllCitiesByZip();
        sessionCity.setAttribute("SearchResults", results);

        // Local variable to hold url of results page
        String url =  "/citiesByZipJSP.jsp";

        // Forward the request header to the JSP page
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
