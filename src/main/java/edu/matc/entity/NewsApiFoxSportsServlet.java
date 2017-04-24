package edu.matc.entity;

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
        name = "newsApiFoxSports",
        urlPatterns = { "/NewsApiFoxSports" }
)
/**
 * Created by Sue Hundt on 3/9/17.
 */
public class NewsApiFoxSportsServlet extends HttpServlet {

    static Logger log = Logger.getLogger(NewsApiFoxSportsServlet.class.getName());

    List<ArticlesItem> newFoxSportsHeadlineNews = new ArrayList<ArticlesItem>();



    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        Client sportsClient = ClientBuilder.newClient();
        WebTarget sportsTarget =
                sportsClient.target("https://newsapi.org/v1/articles?source=fox-sports&sortBy=top&apiKey=4e50f2b2b7f441cfaf895d1d91e31a5c");
        String newFoxSportsApiResponse = sportsTarget.request(MediaType.APPLICATION_JSON).get(String.class);
        log.info("************************" + newFoxSportsApiResponse + "********************************");

        ObjectMapper mapper = new ObjectMapper();

        try {

            org.newsapi.newsheadlines.Response apiMapped = mapper.readValue(newFoxSportsApiResponse, org.newsapi.newsheadlines.Response.class);
            newFoxSportsHeadlineNews = apiMapped.getArticles();
        }
        catch (Exception ex) {
            log.error("$$$$$$$$$" + ex + "$$$$$$$$$$$$$$$");

        }


        HttpSession sessionNewsApi = request.getSession();
        sessionNewsApi.setAttribute("noNewsFoundMessage", "");
        sessionNewsApi.setAttribute("SportsNewsResult", newFoxSportsHeadlineNews);

        // Local variable to hold url of results page
        String url =  "/displayNewsApiFoxSports.jsp";

        // Forward the request header to the JSP page
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }


}

