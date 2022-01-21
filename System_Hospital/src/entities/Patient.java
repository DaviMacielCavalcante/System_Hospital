package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Patient {

	private String name;
	private Integer rg;
	private Integer cpf;
	private String street;
	private int house;
	private String district;
	private String city;
	private String state;
	private Date birthDate;
	
	private List<PhoneNumber> phNumb = new ArrayList<>();
	
	
	public Patient() {
		
	}

	public Patient(String name, Integer rg, Integer cpf, String street, int house, String district, String city,
			String state, Date birthDate) {		
		this.name = name;
		this.rg = rg;
		this.cpf = cpf;
		this.street = street;
		this.house = house;
		this.district = district;
		this.city = city;
		this.state = state;
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public void setStreet(String street) {
		this.street = street;
	}

	public int getHouse() {
		return house;
	}

	public void setHouse(int house) {
		this.house = house;
	}

	public String getBairro() {
		return district;
	}

	public void setBairro(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getBirhtDate() {
		return birthDate;
	}

	public List<PhoneNumber> getPhNumb() {
		return phNumb;
	}	
	
}
