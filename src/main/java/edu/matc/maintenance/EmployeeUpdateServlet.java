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
 * EmployeeUpdateServlet takes code passed from updateEmployeeSelectJSP and attempts
 * to update the data base
 *
 * The BwsIntranet program produces a website for internal use of BWS employees
 *
 * @author Sue Hundt
 * @version 1.0
 * @since   2017-02-12
 */
    @WebServlet(
            name = "EmployeeUpdate",
            urlPatterns = { "/EmployeeUpdate" }
    )
    public class EmployeeUpdateServlet extends HttpServlet {

        static Logger log = Logger.getLogger(EmployeeUpdateServlet.class.getName());

    /**
     * doGet takes the keyword sent by the updateEmployeeSelectJSP and
     * attempts to return the record from the database.  If not found, user
     * is notified
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
        public void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            // local variables
            String url = "";

            // Local instances
            Employee emp = new Employee();
            EmployeeDao dao = new EmployeeDao();
            List<Employee> empAsList = new ArrayList<Employee>();


            //  Get session and keyword from parameter
            HttpSession sessionAdd = request.getSession();
            String paramValue = request.getParameter("emailAddress");

            // get record using keyword value
            emp = dao.getEmployeeByEmailAddress(paramValue);

            // if not record found, notify user, else send record
            if (emp == null) {

                sessionAdd.setAttribute("Message", "Employee Email not found : " + paramValue);
                log.warn("Employee Email not found : " + paramValue);
                // Local variable to hold url of results page
                url = "/maintenanceJSPs/updateEmployeeSelectJSP.jsp";
            } else {
                empAsList.add(emp);

                sessionAdd.setAttribute("UpdateResult", empAsList);
                sessionAdd.setAttribute("Message", "");

                // Local variable to hold url of results page
                url = "/maintenanceJSPs/updateEmployeeJSP.jsp";
            }
            // Forward the request header to the JSP page
            RequestDispatcher dispatcher
                    = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);

        }

    /**
     * do Post takes the updated data from the updateEmployeeJSP and update database
     * record
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
        public void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            // Local variables
            String message = "Update NOT Successful, see log file";
            Employee emp;

            String employeeIdAsString;
            int employeeIdUpdate;
            String firstNameUpdate;
            String lastNameUpdate;
            String departmentUpdate;
            String phoneExtensionUpdate;
            String cellPhoneUpdate;
            String emailAddressUpdate;

            // Local instance
            EmployeeDao dao = new EmployeeDao();

            //  Get session and data to update
            HttpSession sessionAdd = request.getSession();

            // update local variables with form data parameters
            employeeIdAsString = request.getParameter("employeeId");
            employeeIdUpdate = Integer.parseInt(employeeIdAsString);
            firstNameUpdate  = request.getParameter("firstName");
            lastNameUpdate = request.getParameter("lastName");
            departmentUpdate = request.getParameter("department");
            phoneExtensionUpdate= request.getParameter("phoneExtension");
            cellPhoneUpdate = request.getParameter("cellPhone");
            emailAddressUpdate = request.getParameter("emailAddress");

            // get employee record by id
            emp = dao.getEmployeeById(employeeIdUpdate);

            // Set fields to updated data
            emp.setFirstName(firstNameUpdate);
            emp.setLastName(lastNameUpdate);
            emp.setDepartment(departmentUpdate);
            emp.setPhoneExtension(phoneExtensionUpdate);
            emp.setCellPhone(cellPhoneUpdate);
            emp.setEmailAddress(emailAddressUpdate);

            // update database
            try {
                dao.updateEmployee(emp);
                message = "Update Successful for : " + emailAddressUpdate;
                sessionAdd.setAttribute("Message", message);
                log.info(message);
            } catch (Exception ex) {
                sessionAdd.setAttribute("Message", message);
                log("Exception thrown trying to update Employee" + ex);
            }

            // Local variable to hold url of results page
            String url = "/maintenanceJSPs/updateEmployeeSelectJSP.jsp";

            // Forward the request header to the JSP page
            RequestDispatcher dispatcher
                    = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);

        }
    }

