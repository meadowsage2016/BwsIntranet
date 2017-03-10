package edu.matc.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wunderground.wundergroundApi.Response;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

/**
 * Created by student on 3/9/17.
 */
public class WundergroundApiTest {

@Before
    public void set() {
        String apiResults = "";
}
    @Test
    public void testApt() {
        String apiResults = "";
        try {
            WundergroundApi weather = new WundergroundApi();
            apiResults = weather.wundergroundApiJSON();
        } catch (Exception ex) {
        }


        ObjectMapper mapper = new ObjectMapper();
        try {
            Response apiMapped = mapper.readValue(apiResults, Response.class);
            Response resultItem = apiMapped.getResponse();
            System.out.println(resultItem);
        }
        catch (Exception ex) {

        }

    }


}