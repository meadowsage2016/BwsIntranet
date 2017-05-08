package edu.matc.maintenance;

import edu.matc.entity.Users;
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

/**
 * Created by student on 3/17/17.
 */
@WebServlet(
        name = "UserDelete",
        urlPatterns = { "/UserDelete" }
)
public class UserDeleteServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Users user = new Users();
        UsersDao dao = new UsersDao();
        List<Users> userAsList = new ArrayList<Users>();
        String url = "";

        //  Take updated Search object and store in Sessio
        HttpSession sessionDelete = request.getSession();
        String paramValue = request.getParameter("userName");

        user = dao.getUserByUserName(paramValue);
        userAsList.add(user);

        if (user == null) {
            sessionDelete.setAttribute("Message", "User not found for: " + paramValue);
            url = "/maintenanceJSPs/deleteUsersSelectJSP.jsp";
        }
        else {

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

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String message = "Delete not Successful";
        int id = 0;

        Users user = new Users();
        UsersDao dao = new UsersDao();

        //  Take updated Search object and store in Session
        HttpSession sessionDelete = request.getSession();
        String userIdToDelete = request.getParameter("userId");
        String userName = request.getParameter("userName");

        int selected = Integer.parseInt(userIdToDelete);

        try {
            dao.deleteUser(selected);
            message="Successful delete of user: " + userName;
            sessionDelete.setAttribute("Message", message);
            // Local variable to hold url of results page
            String url = "/maintenanceJSPs/deleteUsersJSP.jsp";

            // Forward the request header to the JSP page
            RequestDispatcher dispatcher
                    = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);

        } catch (Exception ex) {
        }

    }
}

