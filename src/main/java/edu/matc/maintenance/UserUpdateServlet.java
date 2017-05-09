package edu.matc.maintenance;

import edu.matc.entity.Employee;
import edu.matc.entity.Users;
import edu.matc.persistence.EmployeeDao;
import edu.matc.persistence.UsersDao;
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
@WebServlet(
        name = "UserUpdate",
        urlPatterns = { "/UserUpdate" }
)
/**
 * UserUpdateServlet takes code passed from updateUserSelectJSP and attempts
 * to retrieve record for update, displays record, then updates database table
 *
 * The BwsIntranet program produces a website for internal use of BWS employees
 *
 * @author Sue Hundt
 * @version 1.0
 * @since   2017-02-12
 */
public class UserUpdateServlet extends HttpServlet {

    static Logger log = Logger.getLogger(UserUpdateServlet.class.getName());

    /**
     * doGet gets keyword from updateUsersSelectJSP and tries to retrieve
     * for update - sends message if it doesn't exist
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Local variables
        String url = "";

        // Local instances
        List<Users> users = new ArrayList<Users>();
        Users user = new Users();
        UsersDao dao = new UsersDao();

        //  get session, get keyword parameter value
        HttpSession sessionAdd = request.getSession();
        String paramValue = request.getParameter("userName");

        // get record by keyword
        user = dao.getUserByUserName(paramValue);

        // If record is not returned, send message that user doesn't exist
        if (user == null) {

            sessionAdd.setAttribute("Message", "User does not exist: " + paramValue);
            log.warn("User does not exist: " + paramValue);
            // Local variable to hold url of results page
            url = "/maintenanceJSPs/updateUserSelectJSP.jsp";

        } else {
            users.add(user);

            sessionAdd.setAttribute("UpdateResult", users);
            sessionAdd.setAttribute("Message", "");
            log.info("user found");
            // Local variable to hold url of results page
            url = "/maintenanceJSPs/updateUserJSP.jsp";
        }
        // Forward the request header to the JSP page
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }

    /**
     * doPost performs the update after user has verified it in UpdateUserJSP
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Local variables
        String message = "Update NOT Successful, see log file";
        String userNameUpdate;
        String userPasswordUpdate;

        // Local instances
        Users user;
        UsersDao dao = new UsersDao();

        //  Get session
        HttpSession sessionAdd = request.getSession();

        // Get field data from parameters
        userNameUpdate = request.getParameter("userName");
        userPasswordUpdate = request.getParameter("userPassword");

        // get user from table
        user = dao.getUserByUserName(userNameUpdate);

        // set variables to new values
        user.setUser_name(userNameUpdate);
        user.setUser_pass(userPasswordUpdate);

        // update table
        try {
            dao.updateUser(user);
            message = "Update Successful for user: " + userNameUpdate;
            log.info(message);
            sessionAdd.setAttribute("Message", message);

        } catch (Exception ex) {
            sessionAdd.setAttribute("Message", message);
            log.warn("exception found in update of user");
        }

        // Local variable to hold url of results page
        String url = "/maintenanceJSPs/updateUserSelectJSP.jsp";

        // Forward the request header to the JSP page
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }
}
