package entities;

import java.util.ArrayList;
import java.util.List;

public class Physician {

	private String name;
	private String crm;		
	private String specName;	
	
	private List<Patient> patient = new ArrayList<>();
	private List<Medications> medication = new ArrayList<>();
	
	public Physician() {
		
	}

	public Physician(String name, String crm, String specName) {		
		this.name = name;
		this.crm = crm;		
		this.specName = specName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCrm() {
		return crm;
	}

	public String getEspecName() {
		return specName;
	}	
	
	public List<Patient> getPatient() {
		return patient;
	}
	
	public void addPatient(Patient patients) {
		patient.add(patients);
	}
	
	public void removePatient(Patient patients) {
		patient.remove(patients);
	}
	
	public void addMedications(Medications medications, Double dose) {
		medication.addAll(medications, dose);
	}
	
	public void removeMedications(Medications medications, Double dose) {
		medication.remove(medications, dose);
	}
}
