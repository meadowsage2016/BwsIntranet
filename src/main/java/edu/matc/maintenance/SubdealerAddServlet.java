package edu.matc.maintenance;

import edu.matc.entity.Subdealers;
import edu.matc.persistence.SubdealersDao;
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
 * Created by student on 4/29/17.
 */
@WebServlet(
        name = "SubdealersAdd",
        urlPatterns = { "/SubdealersAdd" }
)
public class SubdealerAddServlet extends HttpServlet {

    static Logger log = Logger.getLogger(SubdealerAddServlet.class.getName());

        public void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {


            // default Message
            String message = "UnSuccessful Add, see logs ";

            // Int to hold return Id from Add and Instance to return new object
            int id = 0;
            Subdealers newSub = new Subdealers();

            // Local variables to process form data
            Subdealers sub = new Subdealers();

            // Local variables used to test for duplicate record by customer number
            Subdealers duplicateSubdealer = new Subdealers();
            String paramValue;


            SubdealersDao dao = new SubdealersDao();
            List<Subdealers> results = new ArrayList<Subdealers>();

            //  Create Session
            HttpSession sessionAdd = request.getSession();

            // test for duplicate account
            paramValue = request.getParameter("customerNumber");
            duplicateSubdealer = dao.getsubdealerByCustomerNumber(paramValue);

            if (duplicateSubdealer == null) {

                sub.setCustomerName(request.getParameter("customerName"));
                sub.setCustomerNumber(request.getParameter("customerNumber"));
                sub.setSdAddress1(request.getParameter("sdAddress1"));
                sub.setSdAddress2(request.getParameter("sdAddress2"));
                sub.setSdCity(request.getParameter("sdCity"));
                sub.setSdCity(request.getParameter("sdState"));
                sub.setSdCounty(request.getParameter("sdCounty"));
                sub.setSdZipCode(request.getParameter("sdZipCode"));
                sub.setSubdealerNotes(request.getParameter("subdealerNotes"));

                try {
                    id = dao.addSubdealer(sub);
                    if (id == 0) {

                        sessionAdd.setAttribute("Message", message);

                    } else {

                        sessionAdd.setAttribute("Message", "Successful Add of Customer Number:  " + paramValue);

                    }

                } catch (Exception ex) {
                    log("Exception found attempting Subdealer Add:  " + ex);
                }



            } else {

                log("Duplicate found: " + duplicateSubdealer.getCustomerNumber());
                sessionAdd.setAttribute("Message", "Duplicate Record found for Customer Number: " + paramValue);

            }

            // Local variable to hold url of results page
            String url = "/maintenanceJSPs/newSubdealerJSP.jsp";

            // Forward the request header to the JSP page
            RequestDispatcher dispatcher
                    = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);

        }
    }
