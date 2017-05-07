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

/**
     * Created by student on 4/29/17.
     */
    @WebServlet(
            name = "CylinderOptionsUpdate",
            urlPatterns = { "/CylinderOptionsUpdate" }
    )
    public class CylinderOptionsUpdateServlet extends HttpServlet {

        public void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            List<CylinderOptions> cylAsList = new ArrayList<CylinderOptions>();
            CylinderOptions cyl = new CylinderOptions();
            CylinderOptionsDao dao = new CylinderOptionsDao();
            String url = "";

            //  Take updated Search object and store in Sessio
            HttpSession sessionAdd = request.getSession();
            String paramValue = request.getParameter("gasNumber");

            cyl = dao.getCylOptionByGasNumber(paramValue);

            if (cyl == null) {
                sessionAdd.setAttribute("Message", "Cylinder Not Found : " + paramValue);

                // Local variable to hold url of results page
                url = "/maintenanceJSPs/updateCylinderOptionsSelectJSP.jsp";

            } else {
                cylAsList.add(cyl);

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

        public void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

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


            CylinderOptions cyl;

            CylinderOptionsDao dao = new CylinderOptionsDao();

            //  Take updated Search object and store in Sessio
            HttpSession sessionAdd = request.getSession();


            gasNumberUpdate = request.getParameter("gasNumber");
            gasDescriptionUpdate = request.getParameter("gasDescription");
            cylinderCodeUpdate = request.getParameter("cylinderCode");
            cylinderRentString = request.getParameter("cylinderRent");
            cylinderOnePPRentString = request.getParameter("cylinderOnePPRent");
            cylinderFiveYearLeaseString = request.getParameter("cylinderFiveYearLease");
            cylinderPurchaseString = request.getParameter("cylinderPurchase");

            cylinderRent = Double.parseDouble(cylinderRentString);
            cylinderFiveYearLease = Double.parseDouble(cylinderFiveYearLeaseString);
            cylinderOnePPRent = Double.parseDouble(cylinderOnePPRentString);

            cyl = dao.getCylOptionByGasNumber(gasNumberUpdate);

            cyl.setGasDescription(gasDescriptionUpdate);
            cyl.setCylinderCode(cylinderCodeUpdate);
            cyl.setCylinderRent(cylinderRent);
            cyl.setCylinderOnePPRent(cylinderOnePPRent);
            cyl.setCylinderFiveYearLease(cylinderFiveYearLease);
            if (cylinderPurchaseString != null) {
                cylinderPurchase = Double.parseDouble(cylinderPurchaseString);
                cyl.setCylinderPurchase(cylinderPurchase);
            }

            try {
                dao.updateCylOption(cyl);
                message = "Update Successful for gas: " + gasNumberUpdate;
                sessionAdd.setAttribute("Message", message);
            } catch (Exception ex) {
                log("Update has Exception: " + ex);
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

