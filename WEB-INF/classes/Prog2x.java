import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Prog2x extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        response.setContentType("text/html");
		
        PrintWriter out = response.getWriter();
        
		out.println("<html>");
        out.println("<head>");
        out.println("<title>Prog2x</title>");
        out.println("</head>");
        out.println("<body>");
		
		out.print("<h1>Hello "+request.getParameter("uname")+"</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}