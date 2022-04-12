package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.abstracts.AllPhy;
import services.ManagePatients;

public class Physician extends AllPhy implements ManagePatients {

	private List<Patient> patient = new ArrayList<>();
	private List<Medications> medication = new ArrayList<>();
	
	public Physician() {
		
	}
	
	public Physician(String name, String crm, String specName) {
		super(name, crm, specName);		
	}		
	
	public List<Patient> getPatient() {
		return patient;
	}

	public List<Medications> getMedication() {
		return medication;
	}

	@Override
	public void addPatients(Patient patients) {
		patient.add(patients);
		
	}

	@Override
	public void removePatients(Patient patients) {
		patient.remove(patients);
		
	}

	@Override
	public void addMedications(Medications medications) {
		medication.add(medications);		
	}

	@Override
	public void removeMedications(Medications medications) {
		medication.remove(medications);		
	}
	
	@Override
	public String information() {		
		Scanner sc = new Scanner(System.in);
		
		String or = sc.nextLine();		
		sc.close();		
		return inf = or;		
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Médico(a): ");
		sb.append(name + "\n\n");		
		sb.append("Especialização: ");
		sb.append(specName + "\n\n");		
		sb.append("Paciente: ");
		for (Patient p : patient) {
			sb.append(p + "\n\n");
		}
		sb.append("Medicação e Dose: \n\n");
		for (Medications m : medication) {
			sb.append(m + ". \n");
		}			
		return sb.toString();
	}	
	
}
