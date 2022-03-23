package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Patient {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private String name;	
	private String cpf;	
	private Date birthDate;
	private String phoneN;	
	
	public Patient() {
		
	}			

	public Patient(String name, String cpf, Date birthDate, String phoneN) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.birthDate = birthDate;
		this.phoneN = phoneN;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPhoneN() {
		return phoneN;
	}
	
	public void setPhoneN(String phoneN) {
		this.phoneN = phoneN;
	}
	
	@Override
	public String toString() {
		return  name
				+ ", "
				+ cpf
				+ ", "
				+ sdf.format(birthDate)
				+ ", "
				+ phoneN;
	}

	
	
		
}
