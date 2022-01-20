package entities;

public class Medications {

	private String medName;
	private Double dose;
	
	public Medications() {
		
	}

	public Medications(String medName, Double dose) {		
		this.medName = medName;
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
	
	public void increaseDosage(double dose) {
		this.dose += dose;
	}
	
	public void decreaseDosage(double dose) {
		this.dose -= dose;
	}
	
	
}
