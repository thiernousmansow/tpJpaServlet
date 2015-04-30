package servlet;

import fr.istic.tpjpaservlet.domain.Person;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;




import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;








@WebServlet(name="PersonInfo",
urlPatterns={"/PersonInfo"})
public class PersonInfo   extends  HttpServlet{
	   private EntityManagerFactory factory;
	    private EntityManager manager;
	    private EntityTransaction tx;
	    private PrintWriter pw;

	    @Override
	    public void init() throws ServletException {
	        factory = Persistence.createEntityManagerFactory("example");
	        manager = factory.createEntityManager();
	        tx = manager.getTransaction();
	    }
	    
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
	    		throws ServletException, IOException {
    
	        
	        tx.begin();
	       
	        Query query = manager.createQuery("select p from Person p");

	        List<Person> Listepersonnes = query.getResultList();
	        pw = new PrintWriter(resp.getOutputStream());
	        pw.println("<HTML>\n<BODY>");
	        pw.println("<UL>");
	        for(Person personne : Listepersonnes){
	            //pw.println(personne.toString());
	            
	            
	            pw.println("<LI><H1>"+ personne.getName() +"</H1>");
	            pw.println("<UL>");
	            pw.println("<LI>Mail: " + personne.getMail() +"</LI>");
	            pw.println("<LI>Genre: " + personne.getGender() +"</LI>");
	            pw.println("<LI>Profil Facebook : " + personne.getProfil_facebook() +"</LI>");
				
	        }
	        pw.println("<UL>");
	        pw.println("<HTML>\n<BODY>") ;
	        pw.flush();
	        tx.commit();
    
	    }
	    
}
