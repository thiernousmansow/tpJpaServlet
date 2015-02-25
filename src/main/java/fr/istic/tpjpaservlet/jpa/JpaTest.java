package fr.istic.tpjpaservlet.jpa;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import fr.istic.tpjpaservlet.domain.Device;
import fr.istic.tpjpaservlet.domain.ElectronicDevice;
import fr.istic.tpjpaservlet.domain.Heater;
import fr.istic.tpjpaservlet.domain.Home;
import fr.istic.tpjpaservlet.domain.Person;

public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("example");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
    
		// TODO create entity


     	//entity  
		
	    Person pers1 = test.createPersonTest(); 
	    Person amis    = new Person();
	    Home maison1 = test.createHomeTest(); 
	    Device etcdev1= test.createElectroniqueDeviceTest();
	    Device heat1= test.createHeaterTest();
	    
	    amis .setPersonne(pers1);
	    heat1.setHome(maison1);
	    etcdev1.setHome(maison1);
	    maison1.setPerson(pers1);
	    maison1.getDevices().add(heat1);
	    maison1.getDevices().add(etcdev1);
	    pers1.getFriends().add(amis);
		pers1.getHomes().add(maison1);
		
        Person pers2=new   Person("Durant Sylvie","DurantSylvie98@yahoo.fr","M", new Date(05/07/2001),"DurantSylvie");
        Device heat2= new Heater(" 38AV76N","750w");
        Device etcdev2= new ElectronicDevice("AFL38600","650w");
        Home maison2=new Home(400, 5," 37 avenue du professseur charles foulon 37500","192.0.0.2");
        
        heat2.setHome(maison2);
        etcdev2.setHome(maison2);
        maison2.setPerson(pers2);
        maison2.getDevices().add(heat2);
        maison2.getDevices().add(etcdev2);
		pers2.getHomes().add(maison2);
         
 	
  
         
 

		tx.commit();
	
		 manager.persist(pers1);
		 manager.persist(pers2);
		 manager.persist(maison1);
		 manager.persist(maison2);
		 
		 
	

 
    }
	   private Person createPersonTest(){
			Person pers1= new Person("Martin Paul","ouse898@yahoo.fr","M", new Date(2000/01/30),"MartinPaul");
	        return pers1;
					
		}
		private Home createHomeTest(){
			Home maison1=new Home(300, 4," 37 avenue du professseur charles foulon 37500","192.0.0.2");
	        return maison1;
					
		}
		private Device createElectroniqueDeviceTest() {
			Device etcdev1= new ElectronicDevice("AFL37500","500w");
		    return etcdev1;
						
		}
		private Device createHeaterTest(){
			Device h1= new Heater(" 37AV75N","600w");
		    return h1;
						
		}
	


	
				
 
}
	
	
