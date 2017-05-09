package edu.matc.maintenance;

import edu.matc.entity.CylinderOptions;
import edu.matc.entity.Subdealers;
import edu.matc.persistence.CylinderOptionsDao;
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
        name = "SubdealerDelete",
        urlPatterns = { "/SubdealerDelete" }
)
public class SubdealerDeleteServlet extends HttpServlet  {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Subdealers> subAsList = new ArrayList<Subdealers>();
        Subdealers cyl = new Subdealers();
        SubdealersDao dao = new SubdealersDao();
        String url = "";

        //  Take updated Search object and store in Sessio
        HttpSession sessionDelete = request.getSession();
        String paramValue = request.getParameter("customerNumber");

        Subdealers sub = dao.getsubdealerByCustomerNumber(paramValue);

        if (sub == null) {

            sessionDelete.setAttribute("Message", "Subdealer not found: " + paramValue);

            // Local variable to hold url of results page
            url = "/maintenanceJSPs/deleteSubdealersSelectJSP.jsp";

        } else {
            subAsList.add(sub);

            sessionDelete.setAttribute("DeleteResult", subAsList);
            sessionDelete.setAttribute("Message", "");

            // Local variable to hold url of results page
            url = "/maintenanceJSPs/deleteSubdealersJSP.jsp";
        }
        // Forward the request header to the JSP page
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }


        public void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            String message = "Delete not Successful";

            Subdealers sub = new Subdealers();
            SubdealersDao dao = new SubdealersDao();

            //  Take updated Search object and store in Session
            HttpSession sessionDelete = request.getSession();
            String subToDelete = request.getParameter("customerNumber");

            sub = dao.getsubdealerByCustomerNumber(subToDelete);
            int subIdToDelete = sub.getSubdealerId();

            try {
                dao.deleteSubdealer(subIdToDelete);
                message="Successful delete of Subdealer : " + subToDelete;
                sessionDelete.setAttribute("Message", message);
                // Local variable to hold url of results page
                String url = "/maintenanceJSPs/deleteSubdealersSelectJSP.jsp";

                // Forward the request header to the JSP page
                RequestDispatcher dispatcher
                        = getServletContext().getRequestDispatcher(url);
                dispatcher.forward(request, response);

            } catch (Exception ex) {
            }

        }
    }
