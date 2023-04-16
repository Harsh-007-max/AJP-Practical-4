import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Logout extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession s = request.getSession(false);
        s.invalidate();
        Cookie ck[] = request.getCookies();
        for(Cookie c1 : ck){
            if(c1.getName().equals("UserName")){
                c1.setMaxAge(0);
                response.addCookie(c1);
            }
        }
        response.sendRedirect("Login");
    }
    
}
