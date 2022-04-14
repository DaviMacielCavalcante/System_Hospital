package entities;

import java.io.Serializable;
import java.util.Objects;

public class Medications implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String medName;
	private String dose;
	private Fabricantes fabricantes;
	
	public Medications() {
		
	}		

	public Medications(Integer id, String medName, String dose, Fabricantes fabricantes) {
		this.id = id;
		this.medName = medName;
		this.dose = dose;
		this.fabricantes = fabricantes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMedName() {
		return medName;
	}

	public void setMedName(String medName) {
		this.medName = medName;
	}

	public String getDose() {
		return dose;
	}

	public void setDose(String dose) {
		this.dose = dose;
	}

	public Fabricantes getFabricante() {
		return fabricantes;
	}

	public void setFabricante(Fabricantes fabricantes) {
		this.fabricantes = fabricantes;
	}	
	
	@Override
	public int hashCode() {
		return Objects.hash(fabricantes, medName);
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
		return Objects.equals(fabricantes, other.fabricantes) && Objects.equals(medName, other.medName);
	}

	@Override
	public String toString() {
		return "Medications [id=" + id + ", medName=" + medName + ", dose=" + dose + ", fabricantes=" + fabricantes
				+ "]";
	}

	
	
}
