package com.sistemaclinica.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medications")
public class Medications implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String dose;
	private Fabricantes fabricantes;
	
	public Medications() {		
	}

	public Medications(Integer id, String name, String dose, Fabricantes fabricantes) {
		this.id = id;
		this.name = name;
		this.dose = dose;
		this.fabricantes = fabricantes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDose() {
		return dose;
	}

	public void setDose(String dose) {
		this.dose = dose;
	}

	public Fabricantes getFabricantes() {
		return fabricantes;
	}

	public void setFabricantes(Fabricantes fabricantes) {
		this.fabricantes = fabricantes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fabricantes, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medications other = (Medications) obj;
		return Objects.equals(fabricantes, other.fabricantes) && Objects.equals(name, other.name);
	}		
}
