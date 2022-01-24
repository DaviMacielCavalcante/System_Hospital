package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Patient {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private String name;
	private Integer rg;
	private Integer cpf;
	private String street;
	private Integer house;
	private String district;
	private String city;
	private String state;
	private Date birthDate;
	private String phoneN;	
	
	public Patient() {
		
	}

	public Patient(String name, Integer rg, Integer cpf, String street, int house, String district, String city,
			String state, Date birthDate, String phoneN) {
		this.name = name;
		this.rg = rg;
		this.cpf = cpf;
		this.street = street;
		this.house = house;
		this.district = district;
		this.city = city;
		this.state = state;
		this.birthDate = birthDate;
		this.phoneN = phoneN;
	}

	public String getName() {
		return name;
	}
	
	public Integer getRg() {
		return rg;
	}	

	public Integer getCpf() {
		return cpf;
	}
	
	public String getStreet() {
		return street;
	}	

	public int getHouse() {
		return house;
	}
	
	public String getDistrict() {
		return district;
	}	

	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}

	public Date getBirthDate() {
		return birthDate;
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
