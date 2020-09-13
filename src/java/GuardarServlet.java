/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author maric
 */
public class GuardarServlet extends HttpServlet {


    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      //  processRequest(request, response);
        
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
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
            request.getRequestDispatcher("index.jsp").include(request, response);  
        }else{  
            out.println("No se realizo el registro");  
        }  
          
        out.close();  
    }  
  
        
    }

 

