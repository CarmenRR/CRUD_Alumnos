
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

            Cookie[] cks = request.getCookies();
            if (cks != null) {
                for (int i = 0; i < cks.length; i++) {
                    String name = cks[i].getName();
                    String value = cks[i].getValue();
                    if (name.equals("auth")) {
                        break; // sale del ciclo y se queda en la pagina
                    }
                    if (i == (cks.length - 1)) // si la cookies no es valida redirge al index
                    {
                        response.sendRedirect("index.jsp");
                        return; //alto de ejecucion
                    }
                    i++;
                }
            } else {
                response.sendRedirect("index.jsp");
                return;
            }

            String numeroControl = request.getParameter("NUMEROCONTROL");

            AlumnoDAO.delete(numeroControl);
            response.sendRedirect("VerServlet");

        } catch (Exception exc) {
            System.out.println(exc);
        }

    }

}
