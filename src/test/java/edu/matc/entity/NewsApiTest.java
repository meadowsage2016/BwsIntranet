package edu.matc.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.newsapi.newsheadlines.Response;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by student on 4/2/17.
 */
public class NewsApiTest {

        @Before
        public void set() {

            String newsApiResults = "";
        }

        @Test
        public void testApt() {
            String newsApiResults = "";
            try {
                NewsApi news = new NewsApi();
                newsApiResults = news.newsApiJSON();
            } catch (Exception ex) {
            }


            ObjectMapper mapper = new ObjectMapper();
            try {
                Response apiMapped = mapper.readValue(newsApiResults, Response.class);
                List resultItem = apiMapped.getArticles();
                System.out.println(resultItem);
            }
            catch (Exception ex) {

            }

        }

}