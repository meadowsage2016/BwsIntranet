package edu.matc.maintenance;

        import edu.matc.entity.CylinderOptions;
        import edu.matc.persistence.CylinderOptionsDao;
        import javax.servlet.RequestDispatcher;
        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import javax.servlet.http.HttpSession;
        import java.io.IOException;


/**
 * Created by student on 4/29/17.
 */
@WebServlet(
        name = "CylinderOptionsDelete",
        urlPatterns = { "/CylinderOptionsDelete" }
)
public class CylinderOptionsDelete  extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String message = "Delete not Successful";
        int id = 0;

        CylinderOptions cyl = new CylinderOptions();
        CylinderOptionsDao dao = new CylinderOptionsDao();

        //  Take updated Search object and store in Session
        HttpSession sessionDelete = request.getSession();
        String cylToDelete = request.getParameter("gasNumber");

        cyl = dao.getCylOptionByGasNumber(cylToDelete);
        int cylIdToDelete = cyl.getCylinderOptionId();

            try {
                dao.deleteCylOption(cylIdToDelete);
                message="Successful delete.";
                sessionDelete.setAttribute("Message", message);
                // Local variable to hold url of results page
                String url = "/deleteCylinderOptionsJSP.jsp";

                // Forward the request header to the JSP page
                RequestDispatcher dispatcher
                        = getServletContext().getRequestDispatcher(url);
                dispatcher.forward(request, response);

            } catch (Exception ex) {
            }

        }
    }