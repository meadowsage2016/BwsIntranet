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
 * SubdealerDeleteServlet takes code passed from deleteSubdealersSelectJSP and attempts
 * to delete to data base
 *
 * The BwsIntranet program produces a website for internal use of BWS employees
 *
 * @author Sue Hundt
 * @version 1.0
 * @since   2017-02-12
 */
@WebServlet(
        name = "SubdealerDelete",
        urlPatterns = { "/SubdealerDelete" }
)
public class SubdealerDeleteServlet extends HttpServlet  {

    static Logger log = Logger.getLogger(SubdealerDeleteServlet.class.getName());

    /**
     * doGet takes keyword passed from deleteSubdealersSelectJSP,
     * gets record and returns data to deleteSubdealersJSP for
     * verification of delete
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

        //  get session and retrieve subdealer to delete
        HttpSession sessionDelete = request.getSession();
        String paramValue = request.getParameter("customerNumber");

        // get record from DB
        Subdealers sub = dao.getsubdealerByCustomerNumber(paramValue);

        // if record not found, send notice to user
        if (sub == null) {

            sessionDelete.setAttribute("Message", "Subdealer not found: " + paramValue);
            log.warn("Subdealer not found: " + paramValue);

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

    /**
     * doPost takes verified keyword from deleteSubdealersJSP, attempts to delete from database
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
        public void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            // Local variables
            String message = "Delete not Successful";

            // Local instances
            Subdealers sub = new Subdealers();
            SubdealersDao dao = new SubdealersDao();

            //  Get session and keyword to delete
            HttpSession sessionDelete = request.getSession();
            String subToDelete = request.getParameter("customerNumber");

            // get of id of customer
            sub = dao.getsubdealerByCustomerNumber(subToDelete);
            int subIdToDelete = sub.getSubdealerId();

            // delete from database
            try {
                dao.deleteSubdealer(subIdToDelete);
                message="Successful delete of Subdealer : " + subToDelete;
                log.info(message);
                sessionDelete.setAttribute("Message", message);
                // Local variable to hold url of results page
                String url = "/maintenanceJSPs/deleteSubdealersSelectJSP.jsp";

                // Forward the request header to the JSP page
                RequestDispatcher dispatcher
                        = getServletContext().getRequestDispatcher(url);
                dispatcher.forward(request, response);

            } catch (Exception ex) {
                log("Exception found trying to delete subdealer" + ex);
            }

        }
    }
