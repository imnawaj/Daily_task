package servlet_task;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class showallemp extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		
		try{  
			
			Class.forName("com.mysql.jdbc.Driver");  
			  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/student","root","root");   
			  
			PreparedStatement stmt=con.prepareStatement("select * from employee"); 
			ResultSet rs=stmt.executeQuery();
            
             
             ArrayList<entitydata> users =new ArrayList<entitydata>();
             
			while(rs.next()){
			        int id = rs.getInt("empid");
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
					users.add(e);
			
				
			}
			 req.setAttribute("users", users);
			
			
			  
			
			 
		}catch(Exception e){
			System.out.println(e);
		}
		
		 
		 RequestDispatcher rd = req.getRequestDispatcher("alldata.jsp");
		  rd.forward(req, res);  
	}
	 
	}	 
			

			  
			
		  
		
	


