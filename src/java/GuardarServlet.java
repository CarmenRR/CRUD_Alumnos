
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author María del Carmen Reyes Rocha
 */
public class GuardarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

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
        String nombre = request.getParameter("NOMBRE");
        String curso = request.getParameter("CURSO");
        String semestre = request.getParameter("SEMESTRE");

        Alumnos e = new Alumnos();
        e.setNumeroControl(numeroControl);
        e.setNombre(nombre);
        e.setCurso(curso);
        e.setSemestre(semestre);

        int status = AlumnoDAO.save(e);
        if (status > 0) {
            out.print("<p>Datos guardados correctamente!</p>");
            request.getRequestDispatcher("inicio.jsp").include(request, response);
        } else {
            out.println("No se realizo el registro");
        }

        out.close();
    }

}
