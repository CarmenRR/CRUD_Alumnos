
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
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie ck = new Cookie("auth", "un");
        ck.setMaxAge(0);
        response.addCookie(ck);
        response.sendRedirect("index.jsp");
    }

}
