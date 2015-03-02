package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
public class HomeInfo extends HttpServlet {
	 @Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			    response.setContentType("text/html");
			

			    PrintWriter out = response.getWriter();
			    //get the variables entered in the form
			    String superficie =request.getParameter("superficie");
			    String nbr_piece = request.getParameter("nbr_piece");
			    String adresse = request.getParameter("adresse");
			    String adresseIP =request.getParameter("adresseIP");
			    String device = request.getParameter("device");
			    
			    //connection base de donnees
			    String driver = "com.mysql.jdbc.Driver";
			    String url = "jdbc:mysql://anteros.istic.univ-rennes1.fr/base_15009722";
			    String uid = "user_15009722";
			    String psw = "ouse86??";
			    Statement stmt;
			    Connection con;
			    PreparedStatement pst;
			    ResultSet rs;
			    String sql = "INSERT INTO Home (superficie,nbr_piece,adresse,adresseIP,device)" +
			    		"SELECT num_equipement, device FROM device";
			    String sql1 = "SELECT * FROM home";
			/*   
			    try {
			    	Class.forName(driver);
			    	con = DriverManager.getConnection(url,uid,psw);
			    	pst =  con.prepareStatement(sql);
			    	int i= pst.executeUpdate();
			    	out.println(i+"row(s) affected /ajouter avec succes ");
			    	pst = con.prepareStatement(sql);
			    	rs = pst.executeQuery();
			        }
			    
	 */

			    out.println("<HTML>\n<BODY>\n" +

			                "<H1>Recapitulatif des informations de la Maison</H1>\n" +

			                "<UL>\n" +            

			        " <LI>Model: "

			                + request.getParameter("model_equipement") + "\n" +

			                " <LI>Consommation: "

			                + request.getParameter("conso_equipment") + "\n" +

			                " <LI>Type Equipement: "

			                + request.getParameter("type_device") + "\n" +

			                "</UL>\n" +                

			        "</BODY></HTML>");

		}
}
