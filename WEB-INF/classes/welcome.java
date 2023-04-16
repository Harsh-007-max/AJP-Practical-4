import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class welcome extends HttpServlet {
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException{
        HttpSession s = request.getSession(false);
        Cookie ck[] = request.getCookies();
        String username = null,password=null;
        for(Cookie c1:ck){
            if(c1.getName().equals("UserName"))
                username=c1.getValue();
            if(c1.getName().equals("Password"))
                password = c1.getValue();
        }
        if(username.equals("Harsh") && password.equals("Harsh")){
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.print("Welcome <h1>"+username+"</h1>");
            out.print(
                "<Form action='Logout' method='get'><br><br><input type='submit' name='submit' value='Log Out'/></Form>");
            out.close();
        }
    }
    
}
