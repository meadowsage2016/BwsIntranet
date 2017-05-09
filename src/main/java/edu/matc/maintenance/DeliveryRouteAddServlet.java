package edu.matc.maintenance;

import edu.matc.entity.DeliveryRoute;
import edu.matc.persistence.DeliveryRouteDao;
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
 * DeliveryRouteAddServlet takes code passed from newDeliveryRouteJSP and attempts
 * to add to data base
 *
 * The BwsIntranet program produces a website for internal use of BWS employees
 *
 * @author Sue Hundt
 * @version 1.0
 * @since   2017-02-12
 */
@WebServlet(
        name = "DeliveryRouteAdd",
        urlPatterns = { "/DeliveryRouteAdd" }
)
public class DeliveryRouteAddServlet extends HttpServlet {

    static Logger log = Logger.getLogger(CylinderOptionsUpdateServlet.class.getName());

    /**doPost method takes incoming data, checks for duplicate keyword,
     * if unique it is added to the DeliveryRoute table in BWS DB
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Local variables to perform add
        String message = "Add not Successful";
        int id = 0;

        // Instances needed to perform add
        DeliveryRoute route = new DeliveryRoute();
        DeliveryRoute newRoute = new DeliveryRoute();
        DeliveryRoute duplicateRoute = new DeliveryRoute();
        DeliveryRouteDao dao = new DeliveryRouteDao();
        List<DeliveryRoute> results = new ArrayList<DeliveryRoute>();

        //  Get Session and keyword parameter data
        HttpSession sessionAdd = request.getSession();
        String newCityOrBusiness = request.getParameter("city");

        // Try to return record with same keyword - indicates duplicate
        duplicateRoute =  dao.getDeliveryRouteByCityOrBusiness(newCityOrBusiness);

        // If all is well, get the rest of the parameters and add to DB
        if (duplicateRoute == null) {

            route.setDeliveryCityOrBusiness(request.getParameter("city"));
            route.setDeliveryDay(request.getParameter("day"));
            route.setDeliveryFrequency(request.getParameter("frequency"));

            try {
                id = dao.addDeliveryRoute(route);
            } catch (Exception ex) {
                log("Exception found trying to add new Route :" + ex);
            }

            if (id == 0) {
                sessionAdd.setAttribute("Message", message);
            } else {
                newRoute = dao.getDeliveryRouteById(id);
                message = "Successful Add: " + newCityOrBusiness;
                results.add(newRoute);
                sessionAdd.setAttribute("MaintResult", results);
                sessionAdd.setAttribute("Message", message);
            }
        } else {
            message = "City or Business already exists for: " + duplicateRoute.getDeliveryCityOrBusiness();
            sessionAdd.setAttribute("Message", message);
        }

        // Local variable to hold url of results page
        String url = "/maintenanceJSPs/newDeliveryRouteJSP.jsp";

        // Forward the request header to the JSP page
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }
}
