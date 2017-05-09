package edu.matc.maintenance;

import edu.matc.entity.Employee;
import edu.matc.entity.Users;
import edu.matc.persistence.EmployeeDao;
import edu.matc.persistence.UsersDao;

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
 * Created by student on 3/16/17.
 */
public class UserUpdateServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Users> users = new ArrayList<Users>();
        Users user = new Users();
        UsersDao dao = new UsersDao();
        String url = "";

        //  Take updated Search object and store in Sessio
        HttpSession sessionAdd = request.getSession();
        String paramValue = request.getParameter("userName");

        user = dao.getUserByUserName(paramValue);

        if (user == null) {
            sessionAdd.setAttribute("Message", "User does not exist: " + paramValue);

            // Local variable to hold url of results page
            url = "/maintenanceJSPs/updateUserSelectJSP.jsp";

        } else {
            users.add(user);

            sessionAdd.setAttribute("UpdateResult", users);
            sessionAdd.setAttribute("Message", "");

            // Local variable to hold url of results page
            url = "/maintenanceJSPs/updateUserJSP.jsp";
        }
        // Forward the request header to the JSP page
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String message = "Update NOT Successful, see log file";
        String userNameUpdate;
        String userPasswordUpdate;

        Users user;

        UsersDao dao = new UsersDao();

        //  Take updated Search object and store in Sessio
        HttpSession sessionAdd = request.getSession();


        userNameUpdate = request.getParameter("userName");
        userPasswordUpdate = request.getParameter("userPassword");


        user = dao.getUserByUserName(userNameUpdate);

        user.setUser_name(userNameUpdate);
        user.setUser_pass(userPasswordUpdate);

        try {
            dao.updateUser(user);
            message = "Update Successful for user: " + userNameUpdate;
            sessionAdd.setAttribute("Message", message);
        } catch (Exception ex) {
            sessionAdd.setAttribute("Message", message);
        }

        // Local variable to hold url of results page
        String url = "/maintenanceJSPs/updateUserSelectJSP.jsp";

        // Forward the request header to the JSP page
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }
}
