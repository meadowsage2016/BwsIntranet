package edu.matc.entity;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import java.io.FileNotFoundException;


/**
 * Created by student on 3/9/17.
 */
public class WundergroundApi {

    String apiResponse;

    public String wundergroundApiJSON() throws Exception {
        try {
            Client client = ClientBuilder.newClient();
            WebTarget target =
                    client.target("http://api.wunderground.com/api/3f37ec3c7578e618/forecast/geolookup/conditions/q/WI/Madison.json");
            apiResponse = target.request(MediaType.APPLICATION_JSON).get(String.class);
      //      System.out.println(apiResponse);
        }
        catch (Exception ex) {

        }
        return apiResponse;
    }
}
