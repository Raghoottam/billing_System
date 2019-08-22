import java.io.*;
import javax.servlet.*;
import java.sql.*;
public class admin_login extends GenericServlet
{
	Connection con;
	public void init()throws ServletException
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/billing","root","root");
		}
		catch(Exception e)
		{
			System.out.println("hello"+e);
		}
	}
	
	
	
	
	public void service(ServletRequest request,ServletResponse response) throws ServletException,IOException
	{
		response.setContentType("text/html");
		
		PrintWriter pw=response.getWriter();
		
		String us=request.getParameter("username");
		String pd=request.getParameter("password");
	
		try
		{
		String query="select Name,password from admin where ename=? and password=?";
		
		PreparedStatement ps=con.prepareStatement(query);
		
		ps.setString(1,us);

		ps.setString(2,pd);
	
        ResultSet rs=	ps.executeQuery();	
		if(rs.next())
		{
             RequestDispatcher rd=request.getRequestDispatcher("admin_login.html");
             rd.forward(request, response);
		}
		else
		{
		      RequestDispatcher rd=request.getRequestDispatcher("Login.html");
	             rd.forward(request, response);		}
			
		}
		catch(Exception e)
		{
			pw.println("ERROR"+e);
		}
		pw.print("<center><a href='Login.html'>BACK</a>");
	}
}


