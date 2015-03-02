package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;




@WebServlet(name="DeviceInfo",

urlPatterns={"/DeviceInfo"})
public class DeviceInfo extends HttpServlet{

	 @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		    response.setContentType("text/html");
		

		    PrintWriter out = response.getWriter();
		    //get the variables entered in the form
		    String model_equipement =request.getParameter("model_equipement");
		    String conso_equipment = request.getParameter("conso_equipment");
		    String type_device = request.getParameter("type_device");
		    
		    //connection base de donnees
		    String driver = "com.mysql.jdbc.Driver";
		    String url = "jdbc:mysql://anteros.istic.univ-rennes1.fr/base_15009722";
		    String uid = "user_15009722";
		    String psw = "ouse86??";
		    Statement stmt;
		    Connection con;
		    PreparedStatement pst;
		    ResultSet rs;
		    String sql = "insert into Device (conso_equipment, num_home, model_equipement, type_device) values (conso_equipment,1,model_equipement,type_device)";
		   
		    try {
		    	Class.forName(driver);
		    	con = DriverManager.getConnection(url,uid,psw);
		    	pst =  con.prepareStatement(sql);
		    	int i= pst.executeUpdate();
		    	if(i!=0){
		    		      out.println(i+"row(s) affected /ajouter avec succes ");
		    		    }
		    	else {
		    			  out.println("row(s) no affected /ligne non inseree ");
		    		 }
		    		  
		 

		    rs = pst.executeQuery("SELECT * FROM device");
		   
		    while (rs.next()) {

		    out.println("<HTML>\n<BODY>\n" +

		                "<H1>Recapitulatif des informations du Device</H1>\n" +

		                "<UL>\n" +            

		        " <LI>Numero Equipement: "
                      + rs.getString(2)+ "\n" +
		        
                      " <LI>Model: "
                      + rs.getString(4)+ "\n" +
                      
                          " <LI>Numero Maison: "
                          + rs.getString(5)+ "\n" +
                      
		                " <LI>Consommation: "

		                +rs.getString(3) + "\n" +

		                " <LI>Type Equipement: "

		                + rs.getString(1) + "\n" +

		                "</UL>\n" +                

		        "</BODY></HTML>");

	}
		    rs.close();
		    pst.close();
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
