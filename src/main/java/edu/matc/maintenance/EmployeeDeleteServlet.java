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
import java.util.Set;
import java.util.TreeSet;


/**
 * EmployeeDeleteServlet takes code passed from deleteEmployeeSelectJSP and attempts
 * to delete from data base
 *
 * The BwsIntranet program produces a website for internal use of BWS employees
 *
 * @author Sue Hundt
 * @version 1.0
 * @since   2017-02-12
 */
@WebServlet(
        name = "EmployeeDelete",
        urlPatterns = { "/EmployeeDelete" }
)
public class EmployeeDeleteServlet extends HttpServlet  {

    static Logger log = Logger.getLogger(EmployeeDeleteServlet.class.getName());

    /**
     * doGet takes parameter passed from deleteEmployeeSelectJSP, gets the record
     *  and returns to deleteEmployeeJSP for verification of delete, if record is
     *  not found, user is notified
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


        //  get session and keyword variable
        HttpSession sessionDelete = request.getSession();
        String paramValue = request.getParameter("emailAddress");

        // get record from database to send for verification
        emp = dao.getEmployeeByEmailAddress(paramValue);
        empAsList.add(emp);

        // if record isn't found send notificaiton to user, else send record
        if (emp == null) {
            sessionDelete.setAttribute("Message", "Employee not found for emaill address: " + paramValue);
            log.warn("Employee not found for emaill address: " + paramValue);
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

    /**
     * doPost takes the verified keyword and attempt to delete from database
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
        public void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            // Local variables
            String message = "Delete not Successful";
            int id = 0;

            // Local instances
            Employee emp = new Employee();
            EmployeeDao dao = new EmployeeDao();

            //  Get session and keyword parameter
            HttpSession sessionDelete = request.getSession();
            String emailAddressToDelete = request.getParameter("emailAddress");

            // get record from database
            emp = dao.getEmployeeByEmailAddress(emailAddressToDelete);

            // get id from record to perform delete by id
            int selected = emp.getEmployeeId();

            try {
                dao.deleteEmployee(selected);

                message="Successful delete of: " + emailAddressToDelete;
                log.info(message);
                sessionDelete.setAttribute("Message", message);

                // Local variable to hold url of results page
                String url = "/maintenanceJSPs/deleteEmployeesSelectJSP.jsp";

                // Forward the request header to the JSP page
                RequestDispatcher dispatcher
                        = getServletContext().getRequestDispatcher(url);
                dispatcher.forward(request, response);

            } catch (Exception ex) {
                log("Exception thrown trying to delete employee" + ex);
            }

        }
    }

