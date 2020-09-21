
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author María del Carmen Reyes Rocha
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String un = request.getParameter("uname");
        String pwd = request.getParameter("pass");
        if (un.equals("Carmen") && pwd.equals("1234")) {
            out.print("Welcome, " + un);
            HttpSession session = request.getSession(true); // reuse existing
            // session if exist
            // or create one
            session.setAttribute("user", un);
            session.setMaxInactiveInterval(30); // 30 seconds
            response.sendRedirect("inicio.jsp");
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            out.println("<font color=red>Usurio y/o contraseñas incorrectas.</font>");
            rd.include(request, response);
        } // TODO Auto-generated method stub

    }

}
