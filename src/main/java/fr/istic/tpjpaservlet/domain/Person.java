package fr.istic.tpjpaservlet.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;




import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Entity
@Table(name="Person")
@Path(value="/Person")
public class Person {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_person;
	
	private String name;
	private String mail;
	private String gender;
	
	
	private java.sql.Date  date_naiss;
	private String profil_facebook;
	
	@OneToMany(mappedBy="person",cascade = CascadeType.PERSIST,fetch=FetchType.LAZY)
	private List<Home> homes= new ArrayList<Home>() ;
	
	/*Recursion*/
	@ManyToMany
	  @JoinTable(
	      name="amis_personnel",
	      joinColumns={@JoinColumn(name="id_person", referencedColumnName="id_person")},
	      inverseJoinColumns={@JoinColumn(name="id_amis", referencedColumnName="id_person")})
	private List<Person>friends= new ArrayList<Person>() ;
	

	
	

    public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String name, String mail, String gender, Date date_naiss,
			String profil_facebook) {
		super();
		this.name = name;
		this.mail = mail;
		this.gender = gender;
		this.date_naiss = date_naiss;
		this.profil_facebook = profil_facebook;
	}
	public long getId_person() {
		return id_person;
	}
	public void setId_person(long id_person) {
		this.id_person = id_person;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDate_naiss() {
		return date_naiss;
	}
	public void setDate_naiss(Date date_naiss) {
		this.date_naiss = date_naiss;
	}
	public String getProfil_facebook() {
		return profil_facebook;
	}
	public void setProfil_facebook(String profil_facebook) {
		this.profil_facebook = profil_facebook;
	}
	
	
	public List<Home> getHomes() {
		return homes;
	}
	public void setHomes(List<Home> homes) {
		this.homes = homes;
	}

	public List<Person> getFriends() {
		return friends;
	}
	public void setFriends(List<Person> friends) {
		this.friends = friends;
	}

	 public void addHome(Home home) {
		    getHomes().add(home);
		   home.setPerson(this);
		  } 
	 
	  public void addAmis(Person amis) {
	        getFriends().add(amis);
	        if (!amis.getFriends().contains(this)) {
	        	 getFriends().add(this);
	        }
	    }

}