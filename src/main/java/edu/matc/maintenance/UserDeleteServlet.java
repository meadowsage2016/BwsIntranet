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

/**
 * Created by student on 3/17/17.
 */
@WebServlet(
        name = "UserDelete",
        urlPatterns = { "/UserDelete" }
)
public class UserDeleteServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String message = "Delete not Successful";
        int id = 0;

        Users user = new Users();
        UsersDao dao = new UsersDao();

        //  Take updated Search object and store in Session
        HttpSession sessionDelete = request.getSession();
        String userNameToDelete = request.getParameter("userName");

        user = dao.getUserByUserName(userNameToDelete);

        int selected = user.getUser_id();

        try {
            dao.deleteUser(selected);
            message="Successful delete.";
            sessionDelete.setAttribute("Message", message);
            // Local variable to hold url of results page
            String url = "/maintenanceJSPs/deleteUserJSP.jsp";

            // Forward the request header to the JSP page
            RequestDispatcher dispatcher
                    = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);

        } catch (Exception ex) {
        }

    }
}

