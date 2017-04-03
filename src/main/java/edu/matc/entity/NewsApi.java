package edu.matc.entity;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 * Created by student on 3/9/17.
 */
public class NewsApi {

    String newsApiResponse;
    String newsWSJApiResponse;
    String newsSportsApiResponse;

    public String newsApiJSON() throws Exception {
        try {
            Client client = ClientBuilder.newClient();
            WebTarget target =
                    client.target("https://newsapi.org/v1/articles?source=cnn&sortBy=top&apiKey=4e50f2b2b7f441cfaf895d1d91e31a5c");
            newsApiResponse = target.request(MediaType.APPLICATION_JSON).get(String.class);
        }
        catch (Exception ex) {

        }
        return newsApiResponse;
    }

    public String newsWSJApiJSON() throws Exception {
        try {
            Client client = ClientBuilder.newClient();
            WebTarget target =
                    client.target("https://newsapi.org/v1/articles?source=the-wall-street-journal&sortBy=top&apiKey=4e50f2b2b7f441cfaf895d1d91e31a5c");
            newsWSJApiResponse = target.request(MediaType.APPLICATION_JSON).get(String.class);
        }
        catch (Exception ex) {

        }
        return newsWSJApiResponse;
    }

    public String newsSportsApiJSON() throws Exception {
        try {
            Client sportsCclient = ClientBuilder.newClient();
            WebTarget sportsTarget =
                    sportsCclient.target("https://newsapi.org/v1/articles?source=fox-sports&sortBy=top&apiKey=4e50f2b2b7f441cfaf895d1d91e31a5c");
            newsSportsApiResponse = sportsTarget.request(MediaType.APPLICATION_JSON).get(String.class);
        }
        catch (Exception ex) {

        }
        return newsSportsApiResponse;
    }
}
