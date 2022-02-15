package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Physician {

	private String name;
	private String crm;		
	private String specName;
	private String inf;
	
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
	
	public String getInf() {
		return inf;
	}

	public void addPatient(Patient patients) {
		patient.add(patients);
	}
	
	public void removePatient(Patient patients) {
		patient.remove(patients);	
	}
	
	public void addMedications(Medications medication) {
		this.medication.add(medication);
	}
	
	public void removeMedications(Medications medication) {
		this.medication.remove(medication);	
	}
	
	public String information() {
		
		Scanner sc = new Scanner(System.in);
		
		String or = sc.nextLine();		
		sc.close();		
		return inf = or;		
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Doctor name: ");
		sb.append(name + "\n");
		sb.append("Specialization: ");
		sb.append(specName + "\n");
		sb.append("Patient: ");
		for (Patient p : patient) {
			sb.append(p + "\n");
		}
		sb.append("Medication and Dose: \n");
		for (Medications m : medication) {
			sb.append(m + "\n");
		}			
		return sb.toString();
	}
	
	
}
