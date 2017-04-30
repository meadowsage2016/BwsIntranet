package edu.matc.searches;

import edu.matc.entity.Employee;
import edu.matc.persistence.EmployeeDao;

import java.io.*;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(
        name = "employeeSearch",
        urlPatterns = { "/EmployeeSearch" }
)
/**
 * Created by student on 2/24/17.
 */
public class EmployeeSearchServlet  extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EmployeeDao employee = new EmployeeDao();

        // Set Search object variables

        List<Employee> results;

        results = employee.getAllEmployees();

        //  Take updated Search object and store in Sessio
        HttpSession  sessionEmp      = request.getSession();
        sessionEmp.setAttribute("noRecordsFoundMessage", "");

        sessionEmp.setAttribute("SearchResults", results);
//        }

        // Local variable to hold url of results page
        String url =  "/employeeDirectoryJSP.jsp";

        // Forward the request header to the JSP page
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}