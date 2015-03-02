package servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JqueryListHomeSevlet extends HttpServlet
{
public void doGet(HttpServletRequest req, HttpServletResponse res)
throws IOException, ServletException
{
res.setContentType("text/html");
PrintWriter out = res.getWriter();

//connection base de donnees
String driver = "com.mysql.jdbc.Driver";
String url = "jdbc:mysql://anteros.istic.univ-rennes1.fr/base_15009722";
String uid = "user_15009722";
String psw = "ouse86??";
Statement stmt;
Connection con;
PreparedStatement pst;
ResultSet rs;
String sql2 = "SELECT * FROM device";

try
{
Class.forName(driver);
con = DriverManager.getConnection(url,uid,psw);

pst = con.prepareStatement(sql2);
rs = pst.executeQuery(sql2);

while(rs.next()){
	Integer num_equipement = rs.getInt(1);
	String model_equipement = rs.getString(2);
	Integer num_home = rs.getInt(1);
	String conso_equipment = rs.getString(3);
	Integer type_device  = rs.getInt(4);
	out.println("<tr>");
	out.println("<td>"+num_equipement+"</td>");
	out.println("<td>"+model_equipement+"</td>");
	out.println("<td>"+num_home+"</td>");
	out.println("<td>"+conso_equipment+"</td>");
	out.println("<td>"+type_device+"</td>");
}
out.println("</table>");
}
catch(SQLException sx)
{
out.println(sx);
}
catch(ClassNotFoundException cx)
{
out.println(cx);
}
}
}