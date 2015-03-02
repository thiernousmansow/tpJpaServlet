package fr.istic.tpjpaservlet.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="ElectronicDevice")
@DiscriminatorValue("Chauffage")
public class Heater extends Device {

	public Heater() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Heater(String model_equipement, String conso_equipment) {
		super(model_equipement, conso_equipment);
		// TODO Auto-generated constructor stub
	}


}