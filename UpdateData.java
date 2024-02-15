package student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateData extends HttpServlet {
	
protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	    int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String course = req.getParameter("course");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagement","root","Mkr@12345");
        PreparedStatement ps = con.prepareStatement("update studentdetails name=?,age=?,course=?,email=?,password=? where id=?");
	    
		ps.setString(1, name);
		ps.setInt(2, age);
		ps.setString(3, course);
		ps.setString(4, email);
		ps.setString(5, password);
		ps.setInt(6, id);
		
		ps.execute();
		
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
