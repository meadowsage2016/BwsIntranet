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
        name = "SubdealersUpdate",
        urlPatterns = { "/SubdealersUpdate" }
)

public class SubdealerUpdateServlet extends HttpServlet {

        public void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            List<Subdealers> subAsList = new ArrayList<Subdealers>();
            Subdealers cyl = new Subdealers();
            SubdealersDao dao = new SubdealersDao();
            String url = "";
            //  Take updated Search object and store in Sessio
            HttpSession sessionAdd = request.getSession();
            String paramValue = request.getParameter("customerNumber");

            Subdealers sub = dao.getsubdealerByCustomerNumber(paramValue);

            if (sub == null) {
                sessionAdd.setAttribute("Message", "Subdealer Not Found: " + paramValue);

                // Local variable to hold url of results page
                url = "/maintenanceJSPs/updateSubdealersSelectJSP.jsp";

            } else {
                subAsList.add(sub);

                sessionAdd.setAttribute("UpdateResult", subAsList);
                sessionAdd.setAttribute("Message", "");

                // Local variable to hold url of results page
                url = "/maintenanceJSPs/updateSubdealersJSP.jsp";
            }
            // Forward the request header to the JSP page
            RequestDispatcher dispatcher
                    = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);

        }

        public void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            String customerIdString;
            int customerId;
            String customerNumberUpdate;
            String customerNameUpdate;
            String sdAddress1Update;
            String sdAddress2Update;
            String sdCityUpdate;
            String sdStateUpdate;
            String sdZipCodeUpdate;
            String sdCountyUpdate;
            String subdealerNotesUpdate;

            String message = "Update NOT Successful, see log file";
            Subdealers sub;

            SubdealersDao dao = new SubdealersDao();

            //  Take updated Search object and store in Sessio
            HttpSession sessionAdd = request.getSession();

            customerIdString = request.getParameter("customerId");
            customerNumberUpdate = request.getParameter("customerNumber");
            customerNameUpdate = request.getParameter("customerName");
            sdAddress1Update = request.getParameter("sdAddress1");
            sdAddress2Update = request.getParameter("sdAddress2");
            sdCityUpdate = request.getParameter("city");
            sdStateUpdate = request.getParameter("state");
            sdZipCodeUpdate = request.getParameter("ZipCode");
            sdCountyUpdate = request.getParameter("county");
            subdealerNotesUpdate = request.getParameter("subdealerNotes");

            customerId = Integer.parseInt(customerIdString);
            sub = dao.getSubdealerById(customerId);

            sub.setCustomerNumber(customerNumberUpdate);
            sub.setCustomerName(customerNameUpdate);
            sub.setSdAddress1(sdAddress1Update);
            sub.setSdAddress2(sdAddress2Update);
            sub.setSdCity(sdCityUpdate);
            sub.setSdState(sdStateUpdate);
            sub.setSdZipCode(sdZipCodeUpdate);
            sub.setSdCounty(sdCountyUpdate);
            sub.setSubdealerNotes(subdealerNotesUpdate);

            try {
                dao.updateSubdealer(sub);
                message = "Update Successful";
                sessionAdd.setAttribute("Message", message);
            } catch (Exception ex) {
                sessionAdd.setAttribute("Message", message);
            }

            // Local variable to hold url of results page
            String url = "/maintenanceJSPs/updateSubdealersSelectJSP.jsp";

            // Forward the request header to the JSP page
            RequestDispatcher dispatcher
                    = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);

        }
    }

