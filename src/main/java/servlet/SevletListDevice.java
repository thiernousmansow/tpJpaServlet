package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SevletListDevice {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
			{
			res.setContentType("text/html");
			PrintWriter pw = res.getWriter();
			Connection con;
			Statement stmt;
			ResultSet rs;
			try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:myServlet");
			stmt = con.createStatement();
			rs = stmt.executeQuery("Select * from servlet");
			pw.println("Id "+ " Name" +" Address" + "<br>");
			while(rs.next())
			{
			pw.println(rs.getInt(1)+" "+rs.getString(2) + " " + rs.getString(3) + "<br>");
			}
			}
			catch (Exception e){
			pw.println(e);
			}
			}

}
