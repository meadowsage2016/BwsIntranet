package edu.matc.maintenance;

import edu.matc.entity.CylinderOptions;
import edu.matc.persistence.CylinderOptionsDao;
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
 * CylinderOptionsAddServlet takes code passed from newCylinderOptionsJSP and attempts
 * to add to data base
 *
 * The BwsIntranet program produces a website for internal use of BWS employees
 *
 * @author Sue Hundt
 * @version 1.0
 * @since   2017-02-12
 */

@WebServlet(
        name = "CylinderOptionsAdd",
        urlPatterns = { "/CylinderOptionsAdd" }
)
public class CylinderOptionsAddServlet  extends HttpServlet{

    static Logger log = Logger.getLogger(CylinderOptionsAddServlet.class.getName());
    /**
     * doPost method takes incoming data, checks for duplicate keyword,
     * takes incoming string data and converts to double for posting to
     * the database file CylinderOptions in data base BWS
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Local variables used to process incoming data
        String message = "Add not Successful";
        int id = 0;
        double dpurchase = 0;
        CylinderOptions cyl = new CylinderOptions();
        CylinderOptions newCyl = new CylinderOptions();
        CylinderOptionsDao dao = new CylinderOptionsDao();
        List<CylinderOptions> results = new ArrayList<CylinderOptions>();


        // local variables used to check for duplicate record by gas number
        String paramValue;
        CylinderOptions dupCyl = new CylinderOptions();


        //  Get Session and get keyword parameter (gasNumber)
        HttpSession sessionAdd = request.getSession();
        paramValue =  request.getParameter("gasNumber");

        // Try to retrieve by keyword
        dupCyl = dao.getCylOptionByGasNumber(paramValue);

        // If the keyword doesn't exist, process new record
        if (dupCyl == null) {

            // Get data from form parameters
            String daily = request.getParameter("cylinderRent");
            String lease = request.getParameter("cylinderFiveYearLease");
            String rent = request.getParameter("cylinderOnePPRent");
            String purchase = request.getParameter("cylinderPurchase");

            // Convert string data to double for number values
            double ddaily = Double.parseDouble(daily);
            double dlease = Double.parseDouble(lease);
            double drent = Double.parseDouble(rent);
            if (purchase.length() > 0) {
                dpurchase = Double.parseDouble(purchase);
                cyl.setCylinderPurchase(dpurchase);
            }

            // set fields in new CylinderOptions Object
            cyl.setGasNumber(request.getParameter("gasNumber"));
            cyl.setCylinderCode(request.getParameter("cylinderCode"));
            cyl.setCylinderFiveYearLease(dlease);
            cyl.setCylinderOnePPRent(drent);
            cyl.setGasDescription(request.getParameter("gasDescription"));
            cyl.setCylinderRent(ddaily);

            // Add to database
            try {
                id = dao.addCylOptions(cyl);
            } catch (Exception ex) {
                log.warn("Exception found trying to add new Cylinder Option :" + ex);
            }

            // Check for valid response from dao
            if (id == 0) {
                sessionAdd.setAttribute("Message", message);
            } else {
                newCyl = dao.getCylOptionById(id);
                message = "Successful Add of Cylinder: " + paramValue;
                log.info(message);
                results.add(newCyl);
                sessionAdd.setAttribute("Message", message);
            }
        } else {
            log.warn("Duplicate record found for gas number: " + paramValue);
            sessionAdd.setAttribute("Message", "Duplicate record found for gas number: " + paramValue);
        }

        // Local variable to hold url of results page
        String url = "/maintenanceJSPs/newCylinderOptionsJSP.jsp";

        // Forward the request header to the JSP page
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }
}
