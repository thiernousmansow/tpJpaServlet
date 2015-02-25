package fr.istic.tpjpaservlet.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="Home")
public class Home {



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int num_home;
	private int superficie;
	private int nbr_piece;
	private String adresse;
	private String adresseIP;
	@ManyToOne
 	@JoinColumn(name="id_person")
	private Person person ;
	@OneToMany(mappedBy="home",fetch=FetchType.LAZY)
	private List<Device> Devices= new ArrayList<Device>() ;

	
	public Home() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Home(int superficie, int nbr_piece, String adresse,
			String adresseIP) {
		super();
		this.superficie = superficie;
		this.nbr_piece = nbr_piece;
		this.adresse = adresse;
		this.adresseIP = adresseIP;
	
	}

	public int getNum_home() {
		return num_home;
	}


	public void setNum_home(int num_home) {
		this.num_home = num_home;
	}


	public int getSuperficie() {
		return superficie;
	}


	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getAdresseIP() {
		return adresseIP;
	}


	public void setAdresseIP(String adresseIP) {
		this.adresseIP = adresseIP;
	}


	public Person getPerson() {
		return person;
	}


	public void setPerson(Person person) {
		this.person = person;
	}


	public List<Device> getDevices() {
		return Devices;
	}


	public void setDevices(List<Device> devices) {
		Devices = devices;
	}

}