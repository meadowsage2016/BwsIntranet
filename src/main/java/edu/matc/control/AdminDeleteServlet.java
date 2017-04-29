package edu.matc.control;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Created by student on 3/17/17.
 */
@WebServlet(
        name = "AdministratorDelete",
        urlPatterns = { "/AdministratorMaintDelete" }
)
public class AdminDeleteServlet extends HttpServlet {
}
