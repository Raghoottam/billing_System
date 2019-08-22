

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

/**
 * Servlet implementation class FetchAll
 */
@WebServlet("/FetchAll")
public class FetchAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/placmast");
		String app="select * from student";
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(app);
		java.sql.ResultSet rs=ps.executeQuery();
		ArrayList<Student> lot=new ArrayList<Student>();
		Student s=null;
		while(rs.next())
		{
			s=new Student();
			s.setUsn(rs.getLong("usn"));
			s.setSname(rs.getString("sname"));

			s.setDept(rs.getString("dept"));

			s.setSkills(rs.getString("skills"));

			s.setIntrest(rs.getString("intrest"));

			s.setStatus(rs.getString("status"));
			lot.add(s);

		}
		RequestDispatcher dis=request.getRequestDispatcher("Deatails.jsp");
		request.setAttribute("all", lot);
		dis.forward(request, response);
		
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

}
