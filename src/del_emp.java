
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

import java.sql.*;



@WebServlet("/del_emp")
public class del_emp implements Servlet {

  

	Connection con;
    public del_emp() {
        // TODO Auto-generated constructor stub
    }

	
	public void init(ServletConfig config) throws ServletException {

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/billing","root","root");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}	}

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public ServletConfig getServletConfig() {
		
		return null;
	}

	
	public String getServletInfo() {
		
		return null; 
	}

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
response.setContentType("text/html");
		
		PrintWriter pw=response.getWriter();
		

		String USN=request.getParameter("emp_id");
		String UserName=request.getParameter("ename");
		
		
		
	
		try
		{
		String query="delete from student where Usn=? and UserName=?  ";
		
		PreparedStatement ps=con.prepareStatement(query);
		
		ps.setString(1,USN); 
		ps.setString(2,UserName);
		
		
	
        int i=ps.executeUpdate();
		
		if(i>0)
		{
			pw.println("<h1>"+"Successfully Deleted"+"</h1>");
		}
		else
		{
			pw.println("<h1>"+"Please try again "+"</h1>");
		}
			
		}
		catch(Exception e)
		{
			pw.println("ERROR"+e);
		}
		pw.print("<center><a href='admin_login.html'>BACK</a>");
	}
	}


