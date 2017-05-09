package edu.matc.searches;

import edu.matc.entity.DeliveryRoute;
import edu.matc.entity.Users;
import edu.matc.persistence.DeliveryRouteDao;
import edu.matc.persistence.UsersDao;

import java.io.*;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(
        name = "usersSearch",
        urlPatterns = { "/UsersSearch" }
)
/**
 * Created by Susan Hundt on 2/24/17.
 */
public class UsersSearchServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UsersDao users = new UsersDao();

        List<Users> results;

        HttpSession  sessionUsers      = request.getSession();

        results = users.getAllUsers();
        if (results.isEmpty()) {
            sessionUsers.setAttribute("noRecordsFoundMessage", "No User records found");
        }
        else {

            sessionUsers.setAttribute("SearchResults", results);
        }

        // Local variable to hold url of results page
        String url =  "/usersJSP.jsp";

        // Forward the request header to the JSP page
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}