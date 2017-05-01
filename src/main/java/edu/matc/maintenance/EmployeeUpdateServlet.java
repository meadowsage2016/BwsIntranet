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
            name = "EmployeeUpdate",
            urlPatterns = { "/EmployeeUpdate" }
    )
    public class EmployeeUpdateServlet extends HttpServlet {

        public void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            Employee emp = new Employee();
            EmployeeDao dao = new EmployeeDao();
            List<Employee> empAsList = new ArrayList<Employee>();

            //  Take updated Search object and store in Sessio
            HttpSession sessionAdd = request.getSession();
            String paramValue = request.getParameter("emailAddress");

            emp = dao.getEmployeeByEmailAddress(paramValue);
            empAsList.add(emp);

            sessionAdd.setAttribute("UpdateResult", empAsList);

            // Local variable to hold url of results page
            String url = "/maintenanceJSPs/updateEmployeeJSP.jsp";

            // Forward the request header to the JSP page
            RequestDispatcher dispatcher
                    = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);

        }

        public void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            String message = "Update NOT Successful, see log file";
           Employee emp;

            EmployeeDao dao = new EmployeeDao();

            //  Take updated Search object and store in Sessio
            HttpSession sessionAdd = request.getSession();

            String employeeIdAsString;
            int employeeIdUpdate;
            String firstNameUpdate;
            String lastNameUpdate;
            String departmentUpdate;
            String phoneExtensionUpdate;
            String cellPhoneUpdate;
            String emailAddressUpdate;

            employeeIdAsString = request.getParameter("employeeId");
            employeeIdUpdate = Integer.parseInt(employeeIdAsString);
            firstNameUpdate  = request.getParameter("firstName");
            lastNameUpdate = request.getParameter("lastName");
            departmentUpdate = request.getParameter("department");
            phoneExtensionUpdate= request.getParameter("phoneExtension");
            cellPhoneUpdate = request.getParameter("cellPhone");
            emailAddressUpdate = request.getParameter("emailAddress");

            emp = dao.getEmployeeById(employeeIdUpdate);

            emp.setFirstName(firstNameUpdate);
            emp.setLastName(lastNameUpdate);
            emp.setDepartment(departmentUpdate);
            emp.setPhoneExtension(phoneExtensionUpdate);
            emp.setCellPhone(cellPhoneUpdate);
            emp.setEmailAddress(emailAddressUpdate);

            try {
                dao.updateEmployee(emp);
                message = "Update Successful";
                sessionAdd.setAttribute("Message", message);
            } catch (Exception ex) {
                sessionAdd.setAttribute("Message", message);
            }

            // Local variable to hold url of results page
            String url = "/maintenanceJSPs/updateEmployeeSelectJSP.jsp";

            // Forward the request header to the JSP page
            RequestDispatcher dispatcher
                    = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);

        }
    }

