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

public class SingleData1 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		System.out.println("sjhgadkjsd");
		int id = Integer.parseInt(req.getParameter("no"));
		System.out.println(id);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/student","root","root");   
			  
			PreparedStatement stmt=con.prepareStatement("select * from employee where empid =?"); 
			stmt.setInt(1,id);
			
			ResultSet rs=stmt.executeQuery();
			
			
			           rs.next();
			                
		                String firstname = rs.getString("empfname");
							String lastname =rs.getString("emplname");
							String address = rs.getString("empaddress");
							String gender = rs.getString("empgender");
							String city  = rs.getString("empcity");
							String state = rs.getString("empstate");
							String dob =rs.getString("empdob");
							String pincode = rs.getString("emppincode");
							String course= rs.getString("empcourse");
							String email= rs.getString("empemail");
				
						entitydata e = new entitydata(id,firstname,lastname,address,gender,city,state,dob,pincode,course,email);
			       req.setAttribute("emp", e);
			       System.out.println(rs);
			     
			con.close();
			
		} catch (Exception e) {
		    System.out.println(e);
		}
		 RequestDispatcher rd = req.getRequestDispatcher("singlebyid.jsp");
		  rd.forward(req, res); 
	}
	
}
