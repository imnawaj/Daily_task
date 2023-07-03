package servlet_task;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class insert extends HttpServlet {

	@SuppressWarnings("unused")
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		
		String address = req.getParameter("address");
		String gender = req.getParameter("gender");
		String city  = req.getParameter("city");
		String state = req.getParameter("state");
		String dob = req.getParameter("dob");
		String pincode = req.getParameter("pincode");
		String course= req.getParameter("course");
		String email= req.getParameter("email");
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/student","root","root");   
			  
			PreparedStatement stmt=con.prepareStatement("insert into employee(`empfname`,`emplname`,`empaddress`,`empgender`,`empcity`,`empstate`,`empdob`,`emppincode`,`empcourse`,`empemail`) values(?,?,?,?,?,?,?,?,?,?)");  
			stmt.setString(1, firstname);
			stmt.setString(2, lastname);
			stmt.setString(3, address);
			stmt.setString(4, gender);
			stmt.setString(5, city);
			stmt.setString(6, state);
			stmt.setString(7, dob);
			stmt.setString(8, pincode);
			stmt.setString(9, course);
			stmt.setString(10, email);
			
			  
			  
			int result=stmt.executeUpdate();  
			  
			  
			con.close(); 
			

			  
			}catch(Exception e){
				System.out.println(e);
			}
		  
		
		 RequestDispatcher rd = req.getRequestDispatcher("insert.jsp");
		   rd.forward(req, res);
	}
	
}
