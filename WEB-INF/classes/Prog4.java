/*Write an application using servlet to perform CRUD operations 
on MySQL database connected to the servlet with type-4 driver. 
Also apply a basic formatting in the page */
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Prog4 extends HttpServlet {
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/test", "root","");
            Statement statement = connection.createStatement();
            if(request.getParameter("pid")!=null){
                String sql = "insert into product values('"+request.getParameter("pid")+"','"+request.getParameter("pname")+"','"+request.getParameter("pprice")+"')";
                int num=statement.executeUpdate(sql);
            }
            ResultSet rs = statement.executeQuery("SELECT * FROM product");
            out.print("<table border=1><tr><th>ID</th><th>Name</th><th>Price</th></tr>");
            while(rs.next()){
                out.print("<tr>"+
                "<td>"+rs.getInt(1)+"</td>"+
                "<td>"+rs.getString(2)+"</td>"+
                "<td>"+rs.getInt(3)+"</td>"+
                "<td><a href=\"Delete\">Delete</a></td>"+
                "<td><a href=\"Update\">Update</a></td>"+
                "</tr>");
            }
            out.print("</table>");
            connection.close();
        } catch(Exception e){
            out.print(e.getMessage()+"errorrrr");
        }
        out.close();
    }
    
}
