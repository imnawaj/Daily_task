package servlet_task;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class deletedata extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 
		String id = req.getParameter("id");
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/student","root","root");   
			  
			PreparedStatement stmt=con.prepareStatement("delete from employee where empid=?"); 
			stmt.setString(1,id);
			
			int rs =stmt.executeUpdate();
			System.out.println(rs);
			  
			con.close();
			
		} catch (Exception e) {
		    System.out.println(e);
		}
		 RequestDispatcher rd = req.getRequestDispatcher("delete.jsp");
		  rd.forward(req, res); 
	}
	
}
