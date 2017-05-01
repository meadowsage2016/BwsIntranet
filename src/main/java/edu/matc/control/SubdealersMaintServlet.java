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
        name = "SubdealersMaint",
        urlPatterns = { "/SubdealersMaint" }
)
public class SubdealersMaintServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //  Take updated Search object and store in Sessio
        HttpSession session = request.getSession(true);
        session.removeAttribute("MaintResult");
        String paramValue = request.getParameter("maint");

        if (paramValue.matches("1")) {
            // Local variable to hold url of results page
            String url = "/maintenanceJSPs/newSubdealerJSP.jsp";

            // Forward the request header to the JSP page
            RequestDispatcher dispatcher
                    = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
        }

        if (paramValue.matches("2")) {
            // Local variable to hold url of results page
            String url = "/maintenanceJSPs/updateSubdealersSelectJSP.jsp";

            // Forward the request header to the JSP page
            RequestDispatcher dispatcher
                    = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
        }

        if (paramValue.matches("3")) {
            // Local variable to hold url of results page
            String url = "/maintenanceJSPs/deleteSubdealersJSP.jsp";

            // Forward the request header to the JSP page
            RequestDispatcher dispatcher
                    = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
        }

    }


}

