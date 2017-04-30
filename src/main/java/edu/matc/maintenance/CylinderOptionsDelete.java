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
        import java.io.PrintWriter;
        import java.util.ArrayList;
        import java.util.List;

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

        //  Take updated Search object and store in Sessio
        HttpSession sessionAdd = request.getSession();
        String cylToDelete = request.getParameter("gasNumber");
        String cylIdToDelete = request.getParameter("idToDelete");

        if(cylIdToDelete == null) {

        }
      else {
            int idDelete = Integer.parseInt(cylIdToDelete);
            try {
                dao.deleteCylOption(idDelete);
                // Local variable to hold url of results page
                String url = "/indexJSP.jsp";

                // Forward the request header to the JSP page
                RequestDispatcher dispatcher
                        = getServletContext().getRequestDispatcher(url);
                dispatcher.forward(request, response);

            } catch (Exception ex) {
            }

        }

        cyl = dao.getCylOptionByGasNumber(cylToDelete);

        int cylId = cyl.getCylinderOptionId();
        String code = cyl.getCylinderCode();
        String desc = cyl.getGasDescription();
        String gasNumb = cyl.getGasNumber();


        String deleteMessage = "Do you want to delete gas number:" + gasNumb + ", Description: " + desc + ", Code: " + code + " ?";

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<form>");
        out.println("<legend>");
        out.println(deleteMessage);
        out.println("</legend>");
        out.println("<input type='submit' value='submit'/>");
        out.println("<a href='indexJSP.jsp'>Cancel</a>");
        out.println("</form>");

        // Local variable to hold url of results page
        String url = "/deleteCylinderOptionsJSP.jsp";

        // Forward the request header to the JSP page
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);


    }
}
