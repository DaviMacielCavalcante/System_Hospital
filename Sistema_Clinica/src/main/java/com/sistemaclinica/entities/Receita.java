package com.sistemaclinica.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "receita")
public class Receita implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "id_phy")
	private Physician physician;	
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "id_pat")
	private Patient patient;	
	
	@ManyToOne
	@JoinColumn(name = "id_medications")
	private Medications medications;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data")
	private Date date;
	
	public Receita() {
	}

	public Receita(Integer id, Physician physician, Patient patient, Medications medications, Date date) {
		this.id = id;
		this.physician = physician;
		this.patient = patient;
		this.medications = medications;
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Physician getPhysician() {
		return physician;
	}

	public void setPhysician(Physician physician) {
		this.physician = physician;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Medications getMedications() {
		return medications;
	}

	public void setMedications(Medications medications) {
		this.medications = medications;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(patient);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Receita other = (Receita) obj;
		return Objects.equals(patient, other.patient);
	}	
}
