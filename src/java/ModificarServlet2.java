
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
public class ModificarServlet2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        //Sesion activa con httpSesion
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

        int status = AlumnoDAO.update(e);
        if (status > 0) {
            response.sendRedirect("VerServlet");
        } else {
            out.println("No se guardaron los cambios");
        }

        out.close();
    }

}
