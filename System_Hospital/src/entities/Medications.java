package entities;

public class Medications {

	private String medName;
	private Double dose;
	
	public Medications() {
		
	}

	public Medications(String medName) {		
		this.medName = medName;
		
	}
	
	public void MedicaDose(Double dose) {
		this.dose = dose;
	}

	public String getMedName() {
		return medName;
	}	

	public Double getDose() {
		return dose;
	}

	public void setDose(Double dose) {
		this.dose = dose;
	}	
	
}
