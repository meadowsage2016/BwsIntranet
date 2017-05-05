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
        name = "UserAdd",
        urlPatterns = { "/UserAdd" }
)

    public class UserAddServlet extends HttpServlet {

        public void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            String message = "Add not Successful";
            int id = 0;

            String newUserName;
            Users user = new Users();
            UsersDao dao = new UsersDao();
            Users newUser = new Users();

            //  Take updated Search object and store in Sessio
            HttpSession sessionAdd = request.getSession();

            user.setUser_name(request.getParameter("userName"));

            user.setUser_pass(request.getParameter("pass1"));

            try {
                id = dao.addUser(user);
            } catch (Exception ex) {

            }
            if (id == 0) {
                sessionAdd.setAttribute("Message", message);
            } else {
                newUser = dao.getUserById(id);
                message = "Successful Add: ";
                newUserName = "New User Added: " + newUser.getUser_name();

                sessionAdd.setAttribute("MaintResult", newUserName);
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

