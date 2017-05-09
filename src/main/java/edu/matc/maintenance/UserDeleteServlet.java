package edu.matc.maintenance;

import edu.matc.entity.Users;
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

/**
 * UserDeleteServlet takes code passed from deleteUserJSP and attempts
 * to delete from data base
 *
 * The BwsIntranet program produces a website for internal use of BWS employees
 *
 * @author Sue Hundt
 * @version 1.0
 * @since   2017-02-12
*/
@WebServlet(
        name = "UserDelete",
        urlPatterns = { "/UserDelete" }
)
public class UserDeleteServlet extends HttpServlet {

    static Logger log = Logger.getLogger(UserDeleteServlet.class.getName());

    /**
     * doGet get parameter from deleteUserSelectJSP and returns details for
     * the user to verify delete
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
        Users user = new Users();
        UsersDao dao = new UsersDao();
        List<Users> userAsList = new ArrayList<Users>();

        //  Get session and get keyword
        HttpSession sessionDelete = request.getSession();
        String paramValue = request.getParameter("userName");

        // get record by keyword
        user = dao.getUserByUserName(paramValue);
        userAsList.add(user);

        // If no record is found send notice, else send data
        if (user == null) {
            sessionDelete.setAttribute("Message", "User not found for: " + paramValue);
            log.warn("User not found for: " + paramValue);
            url = "/maintenanceJSPs/deleteUsersSelectJSP.jsp";
        }
        else {
            log.info("record found for delete of " + paramValue);
            sessionDelete.setAttribute("DeleteResult", userAsList);
            sessionDelete.setAttribute("Message", "");

            // Local variable to hold url of results page
            url = "/maintenanceJSPs/deleteUsersJSP.jsp";
        }


        // Forward the request header to the JSP page
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }

    /**
     * doPost takes the verified keyword and attempts to delete the record from DB
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
        Users user = new Users();
        UsersDao dao = new UsersDao();

        //  get session and parameter values
        HttpSession sessionDelete = request.getSession();
        String userIdToDelete = request.getParameter("userId");
        String userName = request.getParameter("userName");

        // change id string to integer
        int selected = Integer.parseInt(userIdToDelete);

        // delete record
        try {
            dao.deleteUser(selected);
            message="Successful delete of user: " + userName;
            sessionDelete.setAttribute("Message", message);
            log.info("Successful delete of user: " + userName);

            // Local variable to hold url of results page
            String url = "/maintenanceJSPs/deleteUsersJSP.jsp";

            // Forward the request header to the JSP page
            RequestDispatcher dispatcher
                    = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);

        } catch (Exception ex) {
            log.warn("Exception found trying to delete user: " + ex);
        }
    }
}

