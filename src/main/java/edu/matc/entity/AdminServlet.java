package edu.matc.entity;

import edu.matc.persistence.EmployeeDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by student on 3/16/17.
 */
public class AdminServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EmployeeDao employee = new EmployeeDao();

        // Set Search object variables

        List<Employee> results;

        results = employee.getAllEmployees();

        //  Take updated Search object and store in Sessio
        HttpSession sessionEmp      = request.getSession();
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
