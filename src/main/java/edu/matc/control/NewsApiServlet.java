package edu.matc.control;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.newsapi.newsheadlines.ArticlesItem;

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
        name = "newsApi",
        urlPatterns = { "/NewsApi" }
)
/**
 * Created by Sue Hundt on 3/9/17.
 */
public class NewsApiServlet  extends HttpServlet {

    static Logger log = Logger.getLogger(NewsApiServlet.class.getName());

    List<ArticlesItem> newCNNHeadlineNews = new ArrayList<ArticlesItem>();
    List<ArticlesItem> newWSJHeadlineNews = new ArrayList<ArticlesItem>();
    List<ArticlesItem> newSportsHeadlineNews = new ArrayList<ArticlesItem>();


    /**
     *   doGet Creates call to API for Breaking news from 3 Stations, Cnn, WSJ & Fox Sports
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //  Create new Client (CNN), use new WebTarget to get response from Client
        Client cnnClient = ClientBuilder.newClient();
        WebTarget cnnTarget =
                cnnClient.target("https://newsapi.org/v1/articles?source=cnn&sortBy=top&apiKey=4e50f2b2b7f441cfaf895d1d91e31a5c");
        String newsCNNApiResponse = cnnTarget.request(MediaType.APPLICATION_JSON).get(String.class);
        log.info("************************" + newsCNNApiResponse + "********************************");

        // Map the response from the API
        ObjectMapper cnnMapper = new ObjectMapper();

        try {

            org.newsapi.newsheadlines.Response apiMapped = cnnMapper.readValue(newsCNNApiResponse, org.newsapi.newsheadlines.Response.class);
            newCNNHeadlineNews = apiMapped.getArticles();
        }
        catch (Exception ex) {
            log.error("$$$$$$$$$" + ex + "$$$$$$$$$$$$$$$");

        }

        //  Create new Client(Fox Sports), use new WebTarget to get response from Client
        Client sportsClient = ClientBuilder.newClient();
        WebTarget sportsTarget =
                sportsClient.target("https://newsapi.org/v1/articles?source=fox-sports&sortBy=top&apiKey=4e50f2b2b7f441cfaf895d1d91e31a5c");
        String newSportsApiResponse = sportsTarget.request(MediaType.APPLICATION_JSON).get(String.class);
        log.info("************************" + newSportsApiResponse + "********************************");

        // Map the response from the API
        ObjectMapper mapper = new ObjectMapper();

        try {

            org.newsapi.newsheadlines.Response apiMapped = mapper.readValue(newSportsApiResponse, org.newsapi.newsheadlines.Response.class);
            newSportsHeadlineNews = apiMapped.getArticles();
        }
        catch (Exception ex) {
            log.error("$$$$$$$$$" + ex + "$$$$$$$$$$$$$$$");

        }

        //  Create new Client(Wall Street Journal), use new WebTarget to get response from Client
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://newsapi.org/v1/articles?source=the-wall-street-journal&sortBy=top&apiKey=4e50f2b2b7f441cfaf895d1d91e31a5c");
        String newApiWSJResponse = target.request(MediaType.APPLICATION_JSON).get(String.class);
        log.info("************************" + newApiWSJResponse + "********************************");

        // Map the response from the API
        ObjectMapper WSJmapper = new ObjectMapper();

        try {

            org.newsapi.newsheadlines.Response apiMapped = WSJmapper.readValue(newApiWSJResponse, org.newsapi.newsheadlines.Response.class);
            newWSJHeadlineNews = apiMapped.getArticles();
        }
        catch (Exception ex) {
            log.error("$$$$$$$$$" + ex + "$$$$$$$$$$$$$$$");

        }

        // Set Attributes to pass to JSP
        HttpSession sessionNewsApi = request.getSession();
        sessionNewsApi.setAttribute("noNewsFoundMessage", "");
        sessionNewsApi.setAttribute("CNNNewsResult", newCNNHeadlineNews);
        sessionNewsApi.setAttribute("WSJNewsResult", newWSJHeadlineNews);
        sessionNewsApi.setAttribute("SportsNewsResult", newSportsHeadlineNews);

        // Local variable to hold url of results page
        String url =  "/displayNewsApi.jsp";

        // Forward the request header to the JSP page
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }


}