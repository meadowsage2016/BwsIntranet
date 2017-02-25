package edu.matc.entity;

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

        // Local variable references ServletContext
        ServletContext application = getServletContext();

        // Get Searchtype and Searchword submitted from form
        String searchType  = request.getParameter("selectEmployeeSearchType");
        String firstName = request.getParameter("searchEmployeeFirstName");

        // Set Search object variables

        List<Employee> results;

        if(searchType == "1") {

            results = employee.getAllEmployees();

        } else {

            results = employee.getEmployeesByFirstName(firstName);
        }

        //  Take updated Search object and store in Sessio
        HttpSession  session      = request.getSession();
        session.setAttribute("noRecordsFoundMessage", "");

        if (results.isEmpty()) {
            session.setAttribute("noRecordsFoundMessage", "No records found for search criteria entered.");
        }
        else {

            session.setAttribute("SearchResults", results);
        }

        // Local variable to hold url of results page
        String url =  "/employeeDirectoryJSP.jsp";

        // Forward the request header to the JSP page
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}