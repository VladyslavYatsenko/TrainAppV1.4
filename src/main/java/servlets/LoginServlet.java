package servlets;

import com.railway.dao.mysql.impl.DataAccessException;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    final static Logger logger=Logger.getLogger(LoginServlet.class);
    final String login = "Admin";
    final String password = "6991";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        String userName = request.getParameter("login");
        String userPassword = request.getParameter("password");

        if (userName.equals(login) && userPassword.equals(password)) {
            HttpSession session=request.getSession();
            session.setAttribute("username",userName);
            response.sendRedirect("/adminPage.jsp");
            logger.info("Admin came-> "+userName+" password"+userPassword);
//            session.removeAttribute("username");
        } else {
            logger.warn("Error Login-> "+userName+" "+userPassword);
            response.sendRedirect("/index.jsp");
        }

    }
}
