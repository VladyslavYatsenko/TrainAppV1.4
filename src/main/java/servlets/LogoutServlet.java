package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        session.removeAttribute("username");
        session.invalidate();
//        Cookie[] cookies=request.getCookies();
//        for(int i=0;i<cookies.length;i++){
//            cookies[i].setValue("");
//            cookies[i].setPath("/");
//            cookies[i].setMaxAge(0);
//            response.addCookie(cookies[i]);
//        }
        response.sendRedirect("index.jsp");
    }
}
