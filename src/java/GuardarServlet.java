
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author María del Carmen Reyes Rocha
 */
public class GuardarServlet extends HttpServlet {


   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
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
        
      
        String numeroControl=request.getParameter("NUMEROCONTROL");  
        String nombre=request.getParameter("NOMBRE");  
        String curso=request.getParameter("CURSO");  
        String semestre=request.getParameter("SEMESTRE");  
          
        Alumnos e=new Alumnos();  
        e.setNumeroControl(numeroControl);  
        e.setNombre(nombre);  
        e.setCurso(curso);  
        e.setSemestre(semestre);  
          
        int status=AlumnoDAO.save(e);  
        if(status>0){  
            out.print("<p>Datos guardados correctamente!</p>");  
            request.getRequestDispatcher("inicio.jsp").include(request, response);  
        }else{  
            out.println("No se realizo el registro");  
        }  
          
        out.close();  
    }  
  
        
    }

 

