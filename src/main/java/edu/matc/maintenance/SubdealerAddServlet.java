package edu.matc.maintenance;

import edu.matc.entity.Subdealers;
import edu.matc.persistence.SubdealersDao;

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
        name = "SubdealersAdd",
        urlPatterns = { "/SubdealersAdd" }
)
public class SubdealerAddServlet extends HttpServlet {
        public void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            int id = 0;

            Subdealers sub = new Subdealers();
            Subdealers newSub = new Subdealers();
            SubdealersDao dao = new SubdealersDao();
            List<Subdealers> results = new ArrayList<Subdealers>();

            String message = "UnSuccessful Add, see logs ";

            //  Take updated Search object and store in Sessio
            HttpSession sessionAdd = request.getSession();
            String paramValue = request.getParameter("maintType");

            System.out.println("Maintype is : " + paramValue);

            sub.setCustomerName(request.getParameter("customerName"));
            sub.setCustomerNumber(request.getParameter("customerNumber"));
            sub.setSbAddress1(request.getParameter("sbAddress1"));
            sub.setSdAddress2(request.getParameter("sdAddress2"));
            sub.setSdCity(request.getParameter("sdCity"));
            sub.setSdCity(request.getParameter("sdState"));
            sub.setSdCounty(request.getParameter("sdCounty"));
            sub.setSdZipCode(request.getParameter("sdZipCode"));
            sub.setSubdealerNotes(request.getParameter("subdealerNotes"));

            try {
                id = dao.addSubdealer(sub);
            } catch (Exception ex) {

            }

            if (id == 0) {
                sessionAdd.setAttribute("Message", message);
            } else {
                newSub = dao.getSubdealerById(id);
                message = "Successful Add ";
                results.add(newSub);

                sessionAdd.setAttribute("MaintResult", results);
                sessionAdd.setAttribute("Message", message);
            }

            sessionAdd.setAttribute("MaintResult", results);

            // Local variable to hold url of results page
            String url = "/maintenanceJSPs/newSubdealerJSP.jsp";

            // Forward the request header to the JSP page
            RequestDispatcher dispatcher
                    = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);

        }
    }
