package edu.matc.entity;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Created by student on 3/17/17.
 */
@WebServlet(
        name = "AdministratorAdd",
        urlPatterns = { "/AdministratorMaintAdd" }
)
public class AdminAddServlet extends HttpServlet {
}
