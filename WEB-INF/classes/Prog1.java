import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Prog1 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><head><title>Hello World!</title></head><body><h1 >Hello World!</h1></body></html>");
    }
}