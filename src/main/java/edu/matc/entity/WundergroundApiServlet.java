package edu.matc.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wunderground.wundergroundApi.Response;
import edu.matc.persistence.CylinderOptionsDao;
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
import java.util.ArrayList;
import java.util.List;
@WebServlet(
        name = "wundergroundApi",
        urlPatterns = { "/WundergroundApi" }
)
/**
 * Created by student on 3/9/17.
 */
public class WundergroundApiServlet  extends HttpServlet {
    static Logger log = Logger.getLogger(WundergroundApiServlet.class.getName());
        public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

            Client client = ClientBuilder.newClient();
            WebTarget target =
                    client.target("http://api.wunderground.com/api/3f37ec3c7578e618/conditions/q/WI/Madison.json");
            String apiResponse = target.request(MediaType.APPLICATION_JSON).get(String.class);
            log(apiResponse);
 //           System.out.println(apiResponse);

            ObjectMapper mapper = new ObjectMapper();
            try {
                Response apiMapped = mapper.readValue(apiResponse, Response.class);
                Response resultItem = apiMapped.getResponse();
                double tempF = resultItem.getCurrentObservation().getTempF();
                log("tempF: " + tempF);
//               System.out.println(tempF);
            }
            catch (Exception ex) {

            }

            //  Take updated Search object and store in Sessio
            HttpSession sessionCyl = request.getSession();
            sessionCyl.setAttribute("noRecordsFoundMessage", "");


        }
}
