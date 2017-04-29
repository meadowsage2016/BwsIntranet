package edu.matc.control;

import edu.matc.entity.Employee;
import edu.matc.persistence.EmployeeDao;

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
 * Created by student on 4/29/17.
 */
@WebServlet(
        name = "employeeAdd",
        urlPatterns = { "/employeeAdd" }
)
public class EmployeeAddServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String firstName = "";
        String lastName = "";
        String department = "";
        String phoneExtension = "";
        String cellPhone = "";
        int id = 0;

        Employee emp = new Employee();
        Employee employeeAffected = new Employee();
        EmployeeDao dao = new EmployeeDao();

        String results = "Successful Add";

        //  Take updated Search object and store in Sessio
        HttpSession sessionAdd = request.getSession();
        String paramValue = request.getParameter("maintType");

        System.out.println("Maintype is : " + paramValue);

            emp.setFirstName(request.getParameter("firstName"));
            emp.setLastName(request.getParameter("lastName"));
            emp.setDepartment(request.getParameter("department"));
            emp.setPhoneExtension(request.getParameter("phoneExtension"));
            emp.setCellPhone(request.getParameter("cellPhone"));

            id = dao.addEmployee(emp);
            if (id==1) {
                sessionAdd.setAttribute("MaintResult", results);
            }
            else {
                results = "Unsuccessful Add, See Log Data";
            }

            sessionAdd.setAttribute("MaintResult", results);

            // Local variable to hold url of results page
            String url = "/newEmployeeJSP.jsp";

// Forward the request header to the JSP page
            RequestDispatcher dispatcher
                    = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);

    }
}
