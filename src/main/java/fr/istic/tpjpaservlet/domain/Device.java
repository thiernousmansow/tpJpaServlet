package fr.istic.tpjpaservlet.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Device")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_device",
discriminatorType=DiscriminatorType.STRING)
public class Device {



	
	private Long num_equipement;
	private String model_equipement;
	private String conso_equipment;
	
	private Home home;

	public Device() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Device(String model_equipement, String conso_equipment) {
		super();
		this.model_equipement = model_equipement;
		this.conso_equipment = conso_equipment;
	
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getNum_equipement() {
		return num_equipement;
	}


	public void setNum_equipement(Long num_equipement) {
		this.num_equipement = num_equipement;
	}


	public String getModel_equipement() {
		return model_equipement;
	}


	public void setModel_equipement(String model_equipement) {
		this.model_equipement = model_equipement;
	}


	public String getConso_equipment() {
		return conso_equipment;
	}


	public void setConso_equipment(String conso_equipment) {
		this.conso_equipment = conso_equipment;
	}

	@ManyToOne(fetch= FetchType.LAZY)
 	@JoinColumn(name="num_home")
	public Home getHome() {
		return home;
	}


	public void setHome(Home home) {
		this.home = home;
	}



}