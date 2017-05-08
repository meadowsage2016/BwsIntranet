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

/**
 * Created by student on 4/29/17.
 */
@WebServlet(
        name = "employeeAdd",
        urlPatterns = { "/EmployeeAdd" }
)
public class EmployeeAddServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = 0;

        Employee emp = new Employee();
        Employee duplicateEmployee = new Employee();
        EmployeeDao dao = new EmployeeDao();

        String message = "Successful Add";

        //  Take updated Search object and store in Sessio
        HttpSession sessionAdd = request.getSession();

        String newEmployeeEmailAddress = request.getParameter("emailAddress");

        duplicateEmployee = dao.getEmployeeByEmailAddress(newEmployeeEmailAddress);

        if (duplicateEmployee == null) {

            emp.setFirstName(request.getParameter("firstName"));
            emp.setLastName(request.getParameter("lastName"));
            emp.setDepartment(request.getParameter("department"));
            emp.setPhoneExtension(request.getParameter("phoneExtension"));
            emp.setCellPhone(request.getParameter("cellPhone"));
            emp.setEmailAddress(request.getParameter("emailAddress"));

            try {
                id = dao.addEmployee(emp);
            } catch (Exception ex) {
                log("Exception found trying to add new Employee :" + ex);
            }

            if (id != 0) {
                sessionAdd.setAttribute("Message", "New Employee Added: " + newEmployeeEmailAddress);

            } else {
                message = "Unsuccessful Add, See Log Data";
            }

        } else {

            message = "Unsuccessful Add, Employee exists with email address: " + duplicateEmployee.getEmailAddress();
            sessionAdd.setAttribute("Message", message);
        }

        // Local variable to hold url of results page
        String url = "/maintenanceJSPs/newEmployeeJSP.jsp";

        // Forward the request header to the JSP page
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
