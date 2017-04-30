package edu.matc.control;

        import edu.matc.entity.CylinderOptions;
        import edu.matc.persistence.CitiesByZipDao;
        import edu.matc.persistence.CylinderOptionsDao;

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
 * Created by Sue Hundt on 3/16/17.
 */
@WebServlet(
        name = "CylinderOptionsMaint",
        urlPatterns = { "/CylinderOptionsMaint" }
)
public class CylinderOptionsMaintServlet extends HttpServlet { public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    CylinderOptionsDao cyl = new CylinderOptionsDao();

    CylinderOptions result = null;
    List<CylinderOptions> results = new ArrayList<CylinderOptions>();

    //  Take updated Search object and store in Sessio
    HttpSession sessionCylinderOptions     = request.getSession();
    sessionCylinderOptions.setAttribute("noRecordsFoundMessage", "");

    String paramName = "gasNumber";
    String paramValue = request.getParameter(paramName);
    result = cyl.getCylOptionByGasNumber(paramValue);
    sessionCylinderOptions.setAttribute("SearchResults", result);

    // Local variable to hold url of results page
    String url =  "/newCylinderOptionsJSP.jsp";

    // Forward the request header to the JSP page
    RequestDispatcher dispatcher
            = getServletContext().getRequestDispatcher(url);
    dispatcher.forward(request, response);
}
}