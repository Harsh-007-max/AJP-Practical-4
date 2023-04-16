 import java.io.*;
 import javax.servlet.*;
 import javax.servlet.http.*;
 public class Prog3 extends HttpServlet{
        public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            Cookie UserName = new Cookie("UserName", request.getParameter("login"));
            response.addCookie(UserName);
            Cookie Password = new Cookie("Password",request.getParameter("Password"));
            response.addCookie(Password);
            HttpSession s = request.getSession();
            s.setAttribute("Name",null);
            response.sendRedirect("welcome");
        }
 }
