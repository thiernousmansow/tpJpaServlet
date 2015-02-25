package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="userinfo",
urlPatterns={"/UserInfo"})
public class UserInfo extends HttpServlet{
	@Override
	protected  void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException ,IOException{
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<HTML>\n<BODY>\n"+
		                   "<H1>Recapitulatif des informations</H1>\n"+
		                   "<UL>\n"+
		         "<LI>Nom:"		
		                   +req.getParameter ("name")+"\n"+
		         "<LI>Prenom:"	
		                   +req.getParameter ("name")+"\n"+
		          "<LI>Age:"	
		                   +req.getParameter ("age")+"\n"+
		                   "</UL>\n"+
				 "<BODY><HTML>" );
		
	}
}
