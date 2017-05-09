package edu.matc.maintenance;

import edu.matc.entity.Employee;
import edu.matc.persistence.EmployeeDao;
import org.apache.log4j.Logger;

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
 * EmployeeAddServlet takes code passed from newEmployeeJSP and attempts
 * to add to data base
 *
 * The BwsIntranet program produces a website for internal use of BWS employees
 *
 * @author Sue Hundt
 * @version 1.0
 * @since   2017-02-12
 */
@WebServlet(
        name = "employeeAdd",
        urlPatterns = { "/EmployeeAdd" }
)
public class EmployeeAddServlet extends HttpServlet {

    static Logger log = Logger.getLogger(EmployeeAddServlet.class.getName());

    /**
     * doPost method takes incoming data, checks for duplicate keyword,
     * if unique it is added to the Employee table in BWS DB
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Local variables used to add new record
        int id = 0;
        String message = "Successful Add";

        // Local instances to add new record
        Employee emp = new Employee();
        Employee duplicateEmployee = new Employee();
        EmployeeDao dao = new EmployeeDao();

        //  Get session and keyword parameter value
        HttpSession sessionAdd = request.getSession();
        String newEmployeeEmailAddress = request.getParameter("emailAddress");

        // Try to retrieve record - duplicate if found
        duplicateEmployee = dao.getEmployeeByEmailAddress(newEmployeeEmailAddress);

        // If not duplicate, get the rest of the parameters and setup new employee instance
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
                log("Exception found trying to add new Employee");
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
