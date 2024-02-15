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

public class DeleteData extends HttpServlet {
	
protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	    int id = Integer.parseInt(req.getParameter("id"));
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagement","root","Mkr@12345");
        PreparedStatement ps = con.prepareStatement("delete * from studentdetails where id=?");
	    
		ps.setInt(1, id);
		
		ps.execute();
		
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
