
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author María del Carmen Reyes Rocha
 */
public class EliminarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            //Sesion activa
            HttpSession session = request.getSession();
             if (session != null) {
                if (session.getAttribute("user") != null) {
                    String name = (String) session.getAttribute("user");
                } else {
                    response.sendRedirect("index.jsp");
                }
            }
            String numeroControl = request.getParameter("NUMEROCONTROL");

            AlumnoDAO.delete(numeroControl);
            response.sendRedirect("VerServlet");

        } catch (Exception exc) {
            System.out.println(exc);
        }

    }

}
