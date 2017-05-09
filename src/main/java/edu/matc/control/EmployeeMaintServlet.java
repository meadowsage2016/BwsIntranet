package edu.matc.control;

import edu.matc.entity.Employee;
import edu.matc.persistence.EmployeeDao;

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
  * EmployeeMaintServlet takes code passed from AdminJSP and passes control
  * to appropriate maintenance Servlet (Add, Update, Delete)
  *
  * The BwsIntranet program produces a website for internal use of BWS employees
  *
  * @author Sue Hundt
  * @version 1.0
  * @since   2017-02-12
  */
@WebServlet(
        name = "EmployeesMaintServlet",
        urlPatterns = { "/EmployeesMaintServlet" }
)
public class EmployeeMaintServlet extends HttpServlet {

    /** the doGet method reads the option sent from the AdminJSP form
     * and passes it to the rsponsible maintenance JSP
     *
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //  Start Session, Clear previous messages & get maintenance option
        HttpSession session = request.getSession(true);
        session.removeAttribute("Message");
        String paramValue = request.getParameter("maint");

        // Maintenance options are:  1 = Add,  2 = Update,  3 = Delete, 0 = View All

        if (paramValue.matches("1")) {

            // url of Add
            String url = "/maintenanceJSPs/newEmployeeJSP.jsp";

            // Forward the request header to the JSP page
            RequestDispatcher dispatcher
                    = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
        }

        if (paramValue.matches("2")) {

            // url of Update
            String url = "/maintenanceJSPs/updateEmployeeSelectJSP.jsp";

            // Forward the request header to the JSP page
            RequestDispatcher dispatcher
                    = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
        }

        if (paramValue.matches("3")) {

            // url of Delete
            String url = "/maintenanceJSPs/deleteEmployeesSelectJSP.jsp";

            // Forward the request header to the JSP page
            RequestDispatcher dispatcher
                    = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
        }

    }


}
