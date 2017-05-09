package edu.matc.control;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wunderground.wundergroundApi.CurrentObservation;
import com.wunderground.wundergroundApi.Response;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@WebServlet(
        name = "wundergroundApi",
        urlPatterns = { "/WundergroundApi" }
)
/**
 * WundergroundApiServlet gets weather from wunderground API for city:Madison state:WI
 * The BwsIntranet program produces a website for internal use of BWS employees
 *
 * @author Sue Hundt
 * @version 1.0
 * @since   2017-02-12
 */
public class WundergroundApiServlet  extends HttpServlet {

    static Logger log = Logger.getLogger(WundergroundApiServlet.class.getName());

    // Create local instance of CurrentObservation object to receive weather data
    // and variable to hold error messages
    CurrentObservation newForecast = new CurrentObservation();
    String failedMessage = "";

    /**
     *  doGet Method tries to contact the wunderground api and return "conditions" for WI Madison
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("http://api.wunderground.com/api/3f37ec3c7578e618/conditions/q/WI/Madison.json");
        String apiResponse = target.request(MediaType.APPLICATION_JSON).get(String.class);

        // Log response
        log.info("************************" + apiResponse + "********************************");

        // Map response
        ObjectMapper mapper = new ObjectMapper();

        try {

            Response apiMapped = mapper.readValue(apiResponse, Response.class);
            newForecast = apiMapped.getCurrentObservation();

        }
           catch (Exception ex) {
                log.error("Error returning weather data" + ex + " www.wunderground.com");
                failedMessage = "Error returning weather from WunderGround API";
        }

         //  Get session, set attributes, message and forecast object
        HttpSession sessionWunderApi = request.getSession();
        sessionWunderApi.setAttribute("noForecastFoundMessage", failedMessage);
        sessionWunderApi.setAttribute("ForecastResult", newForecast);

        // Local variable to hold url of results page
        String url =  "/displayWundergroundApi.jsp";

        // Forward the request header to the JSP page
        RequestDispatcher dispatcher
                 = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

}
