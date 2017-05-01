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
        name = "CylinderOptionsAdd",
        urlPatterns = { "/CylinderOptionsAdd" }
)
public class CylinderOptionsAddServlet  extends HttpServlet{

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String message = "Add not Successful";
        int id = 0;

        CylinderOptions cyl = new CylinderOptions();
        CylinderOptions newCyl = new CylinderOptions();

        CylinderOptionsDao dao = new CylinderOptionsDao();

        List<CylinderOptions> results = new ArrayList<CylinderOptions>();

        //  Take updated Search object and store in Sessio
        HttpSession sessionAdd = request.getSession();
        String paramValue = request.getParameter("maintType");

        String daily = request.getParameter("cylinderRent");
        String lease = request.getParameter("cylinderFiveYearLease");
        String rent = request.getParameter("cylinderOnePPRent");
        String purchase = request.getParameter("cylinderPurchase");

        double ddaily = Double.parseDouble(daily);
        double dlease = Double.parseDouble(lease);
        double drent = Double.parseDouble(rent);
        double dpurchase = Double.parseDouble(purchase);

        cyl.setCylinderCode(request.getParameter("cylinderCode"));
        cyl.setCylinderFiveYearLease(dlease);
        cyl.setCylinderOnePPRent(drent);
        cyl.setCylinderPurchase(dpurchase);
        cyl.setGasDescription(request.getParameter("gasDescription"));
        cyl.setGasNumber(request.getParameter("gasNumber"));
        cyl.setCylinderRent(ddaily);

        try{
            id = dao.addCylOptions(cyl);
        } catch (Exception ex) {

        }

        System.out.println("Cylinder Option id returned: " + id );

        if (id == 0) {
            sessionAdd.setAttribute("Message", message);
        } else {
            newCyl = dao.getCylOptionById(id);
            message = "Successful Add ";
            results.add(newCyl );

            sessionAdd.setAttribute("MaintResult", results);
            sessionAdd.setAttribute("Message", message);
        }

        // Local variable to hold url of results page
        String url = "/maintenanceJSP/newCylinderOptionsJSP.jsp";

        // Forward the request header to the JSP page
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }
}
