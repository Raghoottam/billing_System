
import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
public class emp_reg extends GenericServlet
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
			System.out.println(e);
		}
	}
	
	
	
	
	public void service(ServletRequest request,ServletResponse response) throws ServletException,IOException
	{
		response.setContentType("text/html");
		
		PrintWriter pw=response.getWriter();
		
		String emp_id=request.getParameter("emp_id");
		String ename=request.getParameter("ename");		
		String salary= request.getParameter("salary");
		String address=request.getParameter("address");
		String phno=request.getParameter("phno");
		String gender=request.getParameter("gender");
		String password=request.getParameter("password");
		
		
		
		try
		{
		String query="insert into employee values(?,?,?,?,?,?,?)";
		
		PreparedStatement ps=con.prepareStatement(query);
		
		ps.setString(1,emp_id); 
		ps.setString(2,ename);
		ps.setString(3,salary);
		ps.setString(4,address);
		ps.setString(5,phno);
		ps.setString(6,gender);
		ps.setString(7,password);
		
		
		int i=ps.executeUpdate();
		
		if(i>0)
		{
			pw.println("<h1>"+"Thanks For Regestring"+"</h1>");
		}
		else
		{
			pw.println("<h1>"+"Please try again "+"</h1>");
		}
			
		}
		catch(Exception e)
		{
			System.out.println("<h1>Please Enter Valid Information</h1>");

			System.out.println(e);
		}
		pw.print("<center><a href='empop.html'>BACK</a>");
	}
} 







	
