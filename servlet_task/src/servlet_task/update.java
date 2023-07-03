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

public class update extends HttpServlet {
	
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
		int id = Integer.parseInt(req.getParameter("id"));
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/student","root","root");   
			  
			PreparedStatement stmt=con.prepareStatement("update employee set empfname=?,emplname=?,empaddress=?,empgender=?,empcity=?,empstate=?,empdob=?,emppincode=?,empcourse=? ,empemail=? where empid=?"); 
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
			stmt.setInt(11, id);
			
			  
			  
			
			int rs=stmt.executeUpdate();  
			  System.out.println(rs);
			  
			con.close(); 
			

			  
			}catch(Exception e){
				System.out.println(e);
			}
		  
		 entitydata e = new entitydata(id,firstname,lastname,address,gender,city,state,dob,pincode,course,email);
		 req.setAttribute("empdata", e);
		 RequestDispatcher rd = req.getRequestDispatcher("update.jsp");
		   rd.forward(req, res);
	}
}
