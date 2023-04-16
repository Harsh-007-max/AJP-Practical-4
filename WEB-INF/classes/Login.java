import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Login extends HttpServlet{
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<Form action='Prog3' method='get'>"+
        "<input type='text' name='login' placeholder='Username'/>"+
        "<br><br>"+
        "<input type='text' name='Password' placeholder='Password'/>"+
        "<br><br>"+
        "<input type='submit' name='submit' value='Log In'/>"+
        "</Form>");
        out.close();
    }
    
}
