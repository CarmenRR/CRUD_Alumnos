
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class VerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
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
            
            //Cerrar sesión
            out.println("</table>");
            out.println("<form action='LogoutServlet' method='post'>");
            out.print("<input type='submit' value='Cerrar sesion'>");
            out.print("</form>");
           
            out.println("<a href='inicio.jsp'>Añadir nuevo alumno</a>");
            out.println("<h1>Lista de Alumnos</h1>");

            List<Alumnos> list = AlumnoDAO.getAllAlumnos();

            out.print("<table border='1' width='100%'");
            out.print("<tr><th>Numero de Control</th><th>Nombre</th><th>Curso</th><th>Semestre</th><th>Editar</th><th>Eliminar</th></tr>");
            for (Alumnos e : list) {
                out.print("<tr><td>" + e.getNumeroControl() + "</td><td>" + e.getNombre() + "</td><td>" + e.getCurso() + "</td><td>" + e.getSemestre() + "</td><td><a href='ModificarServlet?NUMEROCONTROL=" + e.getNumeroControl() + "'>Modificar</a></td><td><a href='EliminarServlet?NUMEROCONTROL=" + e.getNumeroControl() + "'>Eliminar</a></td></tr>");
            }
            out.print("</table>");

            out.close();

        } catch (Exception exc) {
            System.out.println(exc);
        }//catch

    }//metodo doGet

}//Clase
