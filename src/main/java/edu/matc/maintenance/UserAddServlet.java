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
 * UserAddServlet takes code passed from newUserJSP and attempts
 * to add to data base
 *
 * The BwsIntranet program produces a website for internal use of BWS employees
 *
 * @author Sue Hundt
 * @version 1.0
 * @since   2017-02-12
 */
@WebServlet(
        name = "UserAdd",
        urlPatterns = { "/UserAdd" }
)

    public class UserAddServlet extends HttpServlet {

    static Logger log = Logger.getLogger(UserAddServlet.class.getName());

    /**
     * doPost takes data passed from newUserJSP and adds new record to table
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
        public void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            // Local variables
            String message = "Add not Successful";
            int id = 0;

            // Local instances used to add record
            String newUserName;
            Users user = new Users();
            UsersDao dao = new UsersDao();
            Users newUser = new Users();
            Users duplicateUser = new Users();

            //  Get Session
            HttpSession sessionAdd = request.getSession();

            // Get keyword and test for a duplicate account
            newUserName = request.getParameter("userName");
            duplicateUser = dao.getUserByUserName(newUserName);

            // If a duplicate isn't found add record
            if (duplicateUser == null) {

                // get data and set new user
                user.setUser_name(request.getParameter("userName"));
                user.setUser_pass(request.getParameter("pass1"));

                try {
                    id = dao.addUser(user);
                } catch (Exception ex) {
                    log.warn("Exception found during Add of new user: " + ex);
                    sessionAdd.setAttribute("Message", "Exception found during Add of new user: ");

                }


                if (id == 0) {
                    sessionAdd.setAttribute("Message", message);
                } else {

                    newUser = dao.getUserById(id);
                    message = "New User Added: " + newUser.getUser_name();
                    log.info(message);
                    sessionAdd.setAttribute("Message", message);
                }
            } else  {

                message = "Unsuccessful Add, User exists with user name: " + newUserName;
                log.warn(message);
                sessionAdd.setAttribute("Message", message);
            }


        // Local variable to hold url of results page
            String url = "/maintenanceJSPs/newUserJSP.jsp";

            // Forward the request header to the JSP page
            RequestDispatcher dispatcher
                    = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);

        }
}

