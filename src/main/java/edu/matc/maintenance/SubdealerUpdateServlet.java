package edu.matc.maintenance;

import edu.matc.entity.CylinderOptions;
import edu.matc.entity.Subdealers;
import edu.matc.persistence.CylinderOptionsDao;
import edu.matc.persistence.SubdealersDao;
import org.apache.log4j.Logger;

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
 * SubdealerUpdateServlet takes code passed from newSubdealersJSP and attempts
 * to update the data base
 *
 * The BwsIntranet program produces a website for internal use of BWS employees
 *
 * @author Sue Hundt
 * @version 1.0
 * @since   2017-02-12
 */
@WebServlet(
        name = "SubdealersUpdate",
        urlPatterns = { "/SubdealersUpdate" }
)

public class SubdealerUpdateServlet extends HttpServlet {

    static Logger log = Logger.getLogger(SubdealerUpdateServlet.class.getName());

    /**
     * doGet takes keyword passed from updateSubdealerSelectJSP and tries to return
     * the record data to be updated
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
        public void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            // Local variable
            String url = "";

            // Local instances
            List<Subdealers> subAsList = new ArrayList<Subdealers>();
            Subdealers cyl = new Subdealers();
            SubdealersDao dao = new SubdealersDao();

            //  Get session and keyword value from parameter
            HttpSession sessionAdd = request.getSession();
            String paramValue = request.getParameter("customerNumber");

            // try to return record for update
            Subdealers sub = dao.getsubdealerByCustomerNumber(paramValue);

            // If record isn't found, nofity user
            if (sub == null) {

                sessionAdd.setAttribute("Message", "Subdealer Not Found: " + paramValue);
                log.warn("Subdealer Not Found: " + paramValue);
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

    /**
     * doPost gets updated data from updateSubdealersJSP and attempts to update
     * DB
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
        public void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            // local variables
            String subdealerIdString;
            int subdealerId;
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

            //local instances
            Subdealers sub;
            SubdealersDao dao = new SubdealersDao();

            //  get session and parameter values
            HttpSession sessionAdd = request.getSession();

            subdealerIdString = request.getParameter("subdealerId");
            customerNumberUpdate = request.getParameter("customerNumber");
            customerNameUpdate = request.getParameter("customerName");
            sdAddress1Update = request.getParameter("sdAddress1");
            sdAddress2Update = request.getParameter("sdAddress2");
            sdCityUpdate = request.getParameter("city");
            sdStateUpdate = request.getParameter("state");
            sdZipCodeUpdate = request.getParameter("ZipCode");
            sdCountyUpdate = request.getParameter("county");
            subdealerNotesUpdate = request.getParameter("subdealerNotes");

            // convert string id to integer
            subdealerId = Integer.parseInt(subdealerIdString);
            sub = dao.getSubdealerById(subdealerId);

            // set fields to updated values
            sub.setCustomerNumber(customerNumberUpdate);
            sub.setCustomerName(customerNameUpdate);
            sub.setSdAddress1(sdAddress1Update);
            sub.setSdAddress2(sdAddress2Update);
            sub.setSdCity(sdCityUpdate);
            sub.setSdState(sdStateUpdate);
            sub.setSdZipCode(sdZipCodeUpdate);
            sub.setSdCounty(sdCountyUpdate);
            sub.setSubdealerNotes(subdealerNotesUpdate);

            // update database table
            try {
                dao.updateSubdealer(sub);
                message = "Update Successful for Customer Number : " + customerNumberUpdate;
                sessionAdd.setAttribute("Message", message);
                log.info(message);
            } catch (Exception ex) {
                sessionAdd.setAttribute("Message", message);
                log.warn("Exception thrown attempting to update record:" + ex);
            }

            // Local variable to hold url of results page
            String url = "/maintenanceJSPs/updateSubdealersSelectJSP.jsp";

            // Forward the request header to the JSP page
            RequestDispatcher dispatcher
                    = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);

        }
    }

