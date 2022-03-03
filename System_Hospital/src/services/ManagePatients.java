package services;

import entities.Medications;
import entities.Patient;

public interface ManagePatients {

	void addPatients(Patient patients);
	
	void removePatients(Patient patients);
	
	void addMedications(Medications medications);
	
	void removeMedications(Medications medications);
	
	String information();
}
