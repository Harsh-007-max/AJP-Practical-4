import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Update extends HttpServlet{
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<form action=\"Update\" method=\"post\">"+
        "ID:<input type=\"text\" name=\"pid\"/><br/>"+
        "Name:<input type=\"text\" name=\"pname\"/><br/>"+
        "Price:<input type=\"text\" name=\"pprice\"/><br/>"+
        "<input type=\"submit\"/>"+
        "</form>");
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/test","root","");
            Statement statement = connection.createStatement();
            out.print(request.getParameter("pname"));
            String sql = "update product set pname='"+request.getParameter("pname")+"',pprice="+request.getParameter("pprice")+" where pid="+request.getParameter("pid")+"";
            int num = statement.executeUpdate(sql);
            if(num>=0){
                response.sendRedirect("Prog4");
            }else{
                out.print("update not performed");
            }
            connection.close();
        }catch(Exception e){
            out.print(e.getMessage());
        }
        out.close();
    }
}
