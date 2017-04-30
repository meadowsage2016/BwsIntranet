package edu.matc.control;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by student on 3/16/17.
 */
@WebServlet(
        name = "DeliveryRouteMaintServlet",
        urlPatterns = { "/DeliveryRouteMaintServlet" }
)
public class DeliveryMaintServlet extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //  Take updated Search object and store in Sessio
        HttpSession session = request.getSession();
        String paramValue = request.getParameter("maint");

        if (paramValue.matches("1")) {
            // Local variable to hold url of results page
            String url = "/newDeliveryRouteJSP.jsp";

            // Forward the request header to the JSP page
            RequestDispatcher dispatcher
                    = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
        }

    }
}
