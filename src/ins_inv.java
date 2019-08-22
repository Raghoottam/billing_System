
import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
public class ins_inv extends GenericServlet
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
		
		String pid=request.getParameter("pid");
		String pname=request.getParameter("pname");		
		String mrp= request.getParameter("mrp");
		String s_price=request.getParameter("s_price");
		String exp_date=request.getParameter("exp_date");
		String quantity=request.getParameter("quantity");
		
		
		
		try
		{
		String query="insert into employee values(?,?,?,?,?,?)";
		
		PreparedStatement ps=con.prepareStatement(query);
		
		ps.setString(1,pid); 
		ps.setString(2,pname);
		ps.setString(3,mrp);
		ps.setString(4,s_price);
		ps.setString(5,exp_date);
		ps.setString(6,quantity);
	
		
		
		int i=ps.executeUpdate();
		
		if(i>0)
		{
			pw.println("<h1>"+"Thanks For Regestering"+"</h1>");
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
		pw.print("<center><a href='#'>BACK</a>");
	}
} 







	
