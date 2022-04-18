package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Receita implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Physician physician;
	private Patient patient;
	private Medications medications;
	private Date dateTime;	
	
	public Receita() {
		
	}

	public Receita(Integer id, Physician physician, Patient patient, Medications medications, Date dateTime) {		
		this.id = id;
		this.physician = physician;
		this.patient = patient;
		this.medications = medications;
		this.dateTime = dateTime;
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

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
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

	@Override
	public String toString() {
		return "Receita [id=" + id + ", physician=" + physician + ", patient=" + patient + ", medications="
				+ medications + ", dateTime=" + dateTime + "]";
	}
	
	
	
}
