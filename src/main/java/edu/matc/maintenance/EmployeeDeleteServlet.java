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
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


/**
 * Created by student on 4/29/17.
 */
@WebServlet(
        name = "EmployeeDelete",
        urlPatterns = { "/EmployeeDelete" }
)

/**
 * Created by student on 4/30/17.
 */
public class EmployeeDeleteServlet extends HttpServlet  {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Employee emp = new Employee();
        EmployeeDao dao = new EmployeeDao();
        List<Employee> empAsList = new ArrayList<Employee>();
        String url = "";

        //  Take updated Search object and store in Sessio
        HttpSession sessionDelete = request.getSession();
        String paramValue = request.getParameter("emailAddress");

        emp = dao.getEmployeeByEmailAddress(paramValue);
        empAsList.add(emp);

        if (emp == null) {
            sessionDelete.setAttribute("Message", "Employee not found for emaill address: " + paramValue);
            url = "/maintenanceJSPs/deleteEmployeesSelectJSP.jsp";
        }
        else {

            sessionDelete.setAttribute("DeleteResult", empAsList);
            sessionDelete.setAttribute("Message", "");

            // Local variable to hold url of results page
            url = "/maintenanceJSPs/deleteEmployeesJSP.jsp";
        }


        // Forward the request header to the JSP page
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }
        public void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            String message = "Delete not Successful";
            int id = 0;

            Employee emp = new Employee();
            EmployeeDao dao = new EmployeeDao();

            //  Take updated Search object and store in Session
            HttpSession sessionDelete = request.getSession();
            String emailAddressToDelete = request.getParameter("emailAddress");

            emp = dao.getEmployeeByEmailAddress(emailAddressToDelete);

            int selected = emp.getEmployeeId();

            try {
                dao.deleteEmployee(selected);
                message="Successful delete of: " + emailAddressToDelete;
                sessionDelete.setAttribute("Message", message);
                // Local variable to hold url of results page
                String url = "/maintenanceJSPs/deleteEmployeesSelectJSP.jsp";

                // Forward the request header to the JSP page
                RequestDispatcher dispatcher
                        = getServletContext().getRequestDispatcher(url);
                dispatcher.forward(request, response);

            } catch (Exception ex) {
            }

        }
    }

