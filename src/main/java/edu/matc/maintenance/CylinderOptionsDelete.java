package edu.matc.maintenance;

        import edu.matc.entity.CylinderOptions;
        import edu.matc.persistence.CylinderOptionsDao;
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
        import org.apache.log4j.Logger;


/**
 * CylinderOptionsDelete takes code passed from newCylinderOptionsJSP and attempts
 * to 1) (doGet) retrieve the data for that record for user to verify delete and
 * 2) (doPost) delete the record from data base
 *
 * The BwsIntranet program produces a website for internal use of BWS employees
 *
 * @author Sue Hundt
 * @version 1.0
 * @since   2017-02-12
 */
@WebServlet(
        name = "CylinderOptionsDelete",
        urlPatterns = { "/CylinderOptionsDelete" }
)
public class CylinderOptionsDelete  extends HttpServlet {

    static Logger log = Logger.getLogger(CylinderOptionsDelete.class.getName());

    /**
     * Data keyword sent from deleteCylinderOptionsSelectJSP is used
     * to find a record in the data, the record is returned to deleteCylinderOptionsJSP
     * for the user to verify the delet
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Local variables and instances
        List<CylinderOptions> cylAsList = new ArrayList<CylinderOptions>();
        CylinderOptions cyl = new CylinderOptions();
        CylinderOptionsDao dao = new CylinderOptionsDao();
        String url = "";

        //  Get Session and keyword parameter (gasNumber), send message if record
        // doesn't exist, else send record data to deleteCylinder Options JSP to verify delete
        HttpSession sessionDelete = request.getSession();
        String paramValue = request.getParameter("gasNumber");

        // Retrieve record
        cyl = dao.getCylOptionByGasNumber(paramValue);

        // If no record is returned, notify user that the record wasn't found
        if (cyl==null) {

            log.warn("Gas Number not found: " + paramValue);
            sessionDelete.setAttribute("Message", "Gas Number not found: " + paramValue);

            // Send back message to Select options JSP for another attempt
            url = "/maintenanceJSPs/deleteCylinderOptionsSelectJSP.jsp";
        }
        else {
            // pass record back to user to verify
            cylAsList.add(cyl);
            sessionDelete.setAttribute("DeleteResult", cylAsList);
            sessionDelete.setAttribute("Message", "");

            // Local variable to hold url of results page
            url = "/maintenanceJSPs/deleteCylinderOptionsJSP.jsp";

        }

        // Forward the request header to the JSP page
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    /**
     *  doPost performs the delete of the object from the cylinder options DB table
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Local variables
        String message = "Delete not Successful";
        int id = 0;
        String paramValue;
        String url = "";

        // Local instances
        CylinderOptions cyl = new CylinderOptions();
        CylinderOptionsDao dao = new CylinderOptionsDao();

        //  Get session and get keyword parameter
        HttpSession sessionDelete = request.getSession();
        paramValue = request.getParameter("gasNumber");

        cyl = dao.getCylOptionByGasNumber(paramValue);
        int cylIdToDelete = cyl.getCylinderOptionId();

            try {
                dao.deleteCylOption(cylIdToDelete);
                message="Successful delete of Gas Number: " + paramValue;
                log.info(message);
                sessionDelete.setAttribute("Message", message);
            } catch (Exception ex) {
                log.warn("Exception found trying to delete cylinder option:" + ex);
                message="Failed delete of Gas Number: " + paramValue;
                sessionDelete.setAttribute("Message", message);
            }

        // Local variable to hold url of results page
        url = "/maintenanceJSPs/deleteCylinderOptionsSelectJSP.jsp";

        // Forward the request header to the JSP page
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

        }
    }
