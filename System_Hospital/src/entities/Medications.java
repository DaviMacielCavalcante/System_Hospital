package entities;

public class Medications {

	private String medName;
	private String dose;
	
	public Medications() {
		
	}

	public Medications(String medName, String dose) {		
		this.medName = medName;
		this.dose = dose;
	}
	
	public void MedicaDose(String dose) {
		this.dose = dose;
	}

	public String getMedName() {
		return medName;
	}	

	public String getDose() {
		return dose;
	}

	public void setDose(String dose) {
		this.dose = dose;
	}

	@Override
	public String toString() {
		return  medName
				+ ", "
				+ dose;

	}
	
	
}
