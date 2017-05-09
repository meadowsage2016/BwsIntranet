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
 * CylinderOptionsUpdateServlet takes code passed from updateCylinderOptionsJSP and attempts
 * to update the data base
 *
 * The BwsIntranet program produces a website for internal use of BWS employees
 *
 * @author Sue Hundt
 * @version 1.0
 * @since   2017-02-12
 */
    @WebServlet(
            name = "CylinderOptionsUpdate",
            urlPatterns = { "/CylinderOptionsUpdate" }
    )
    public class CylinderOptionsUpdateServlet extends HttpServlet {

    static Logger log = Logger.getLogger(CylinderOptionsUpdateServlet.class.getName());

    /**
     * doget takes the keyword passed from the cylinderOptionsUpdateSelectJSP and returns record
     * details for update
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
        public void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            // Local variables
            String url = "";

            // Local instances
            List<CylinderOptions> cylAsList = new ArrayList<CylinderOptions>();
            CylinderOptions cyl = new CylinderOptions();
            CylinderOptionsDao dao = new CylinderOptionsDao();

            //  get Session and keyword of record to update
            HttpSession sessionAdd = request.getSession();
            String paramValue = request.getParameter("gasNumber");

            // retrieve record from database
            cyl = dao.getCylOptionByGasNumber(paramValue);

            // If the record is not found, notify user
            if (cyl == null) {
                sessionAdd.setAttribute("Message", "Cylinder Not Found : " + paramValue);
                log.warn("Cylinder Not Found : " + paramValue);
                // Local variable to hold url of results page
                url = "/maintenanceJSPs/updateCylinderOptionsSelectJSP.jsp";

            } else {
                cylAsList.add(cyl);
                // send data to update JSP
                sessionAdd.setAttribute("UpdateResult", cylAsList);
                sessionAdd.setAttribute("Message", "");

                // Local variable to hold url of results page
                url = "/maintenanceJSPs/updateCylinderOptionsJSP.jsp";
            }
            // Forward the request header to the JSP page
            RequestDispatcher dispatcher
                    = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);

        }

    /**
     * doPost takes the updated parameters from the updateCylinderOptionsJSP
     * and apply to database
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
        public void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            // local variables
            String message = "Update NOT Successful, see log file";
            String gasNumberUpdate;
            String gasDescriptionUpdate;
            String cylinderCodeUpdate;
            String cylinderRentString;
            String cylinderPurchaseString;
            String cylinderOnePPRentString;
            String cylinderFiveYearLeaseString;
            Double cylinderRent;
            Double cylinderOnePPRent;
            Double cylinderFiveYearLease;
            Double cylinderPurchase;


            // local instances
            CylinderOptions cyl;
            CylinderOptionsDao dao = new CylinderOptionsDao();

            //  Get session
            HttpSession sessionAdd = request.getSession();


            // get parameters from session
            gasNumberUpdate = request.getParameter("gasNumber");
            gasDescriptionUpdate = request.getParameter("gasDescription");
            cylinderCodeUpdate = request.getParameter("cylinderCode");
            cylinderRentString = request.getParameter("cylinderRent");
            cylinderOnePPRentString = request.getParameter("cylinderOnePPRent");
            cylinderFiveYearLeaseString = request.getParameter("cylinderFiveYearLease");
            cylinderPurchaseString = request.getParameter("cylinderPurchase");

            // change input strings to double
            cylinderRent = Double.parseDouble(cylinderRentString);
            cylinderFiveYearLease = Double.parseDouble(cylinderFiveYearLeaseString);
            cylinderOnePPRent = Double.parseDouble(cylinderOnePPRentString);

            // get the record from the database
            cyl = dao.getCylOptionByGasNumber(gasNumberUpdate);

            // set the parameters to the new values
            cyl.setGasDescription(gasDescriptionUpdate);
            cyl.setCylinderCode(cylinderCodeUpdate);
            cyl.setCylinderRent(cylinderRent);
            cyl.setCylinderOnePPRent(cylinderOnePPRent);
            cyl.setCylinderFiveYearLease(cylinderFiveYearLease);
            if (cylinderPurchaseString == null) {
                cyl.setCylinderPurchase(null);
            }
            else {
                cylinderPurchase = Double.parseDouble(cylinderPurchaseString);
                cyl.setCylinderPurchase(cylinderPurchase);
            }

            // Update data base via the dao
            try {
                dao.updateCylOption(cyl);
                message = "Update Successful for gas: " + gasNumberUpdate;
                sessionAdd.setAttribute("Message", message);
                log.info("Update Successful for gas: " + gasNumberUpdate);

            } catch (Exception ex) {
                log("Update has Exception in Cylinder Options update: " + ex);
                sessionAdd.setAttribute("Message", message);
            }

            // Local variable to hold url of results page
            String url = "/maintenanceJSPs/updateCylinderOptionsSelectJSP.jsp";

            // Forward the request header to the JSP page
            RequestDispatcher dispatcher
                    = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);

        }
    }

