package edu.matc.maintenance;

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
import java.util.List;
@WebServlet(
        name = "AdministratorUpdate",
        urlPatterns = { "/AdministratorMaintUpdate" }
)
/**
 * Created by student on 3/16/17.
 */
public class AdminUpdateServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String maintOption = request.getParameter("key");
        String maintTable = request.getParameter("table");

        if (maintTable == "Users") {


        } else if (maintTable == "Employees") {

        } else if (maintTable == "Subdealers") {

        } else if (maintTable == "DeliveryRoutes") {

        } else if (maintTable == "CylinderOptions") {

        } else if (maintTable == "CitiesByZip") {

        } else  {

        }






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
