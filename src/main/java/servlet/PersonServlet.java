package servlet;



import javax.persistence.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import fr.istic.tpjpaservlet.domain.Home;
import fr.istic.tpjpaservlet.domain.Person;

@WebServlet(name="PersonServlet",
urlPatterns={"/PersonServlet"})
public class PersonServlet extends  HttpServlet {

    private EntityManagerFactory factory;
    private EntityManager manager;
    private EntityTransaction tx;
    private PrintWriter pw;
  

  @Override
    public void init() throws ServletException {
        factory =  Persistence
    			.createEntityManagerFactory("example");
        manager = factory.createEntityManager();
        tx = manager.getTransaction();
    }

  
    @SuppressWarnings("deprecation")
	public void doPost(HttpServletRequest request,

            HttpServletResponse response)
				
				throws ServletException, IOException {
				
				response.setContentType("text/html");

        pw = response.getWriter();
        tx.begin();
      
        
        	
        Person person = new Person();
		person.setName(request.getParameter("name"));
		person.setMail(request.getParameter("mail"));
		person.setGender(request.getParameter("gender"));
		person.setProfil_facebook(request.getParameter("profil_facebook"));
		String date_recup=request.getParameter("annee")+"-"+request.getParameter("mois")+"-"+request.getParameter("jour");
		java.util.Date date_recuperer;
		try {
			date_recuperer = new SimpleDateFormat("yyyy-MM-dd").parse( date_recup);
			java.sql.Date date_naiss = new java.sql.Date(date_recuperer.getTime());
			person.setDate_naiss(date_naiss);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		manager.persist(person);
        pw.println("Person ajoutee avec succes.");

        tx.commit();
        response.sendRedirect("/PersonInfo");  

    }


}









