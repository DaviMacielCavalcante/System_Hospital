package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pacient {

	private String name;
	private Integer rg;
	private Integer cpf;
	private String street;
	private int house;
	private String bairro;
	private String city;
	private String state;
	private Date birtDate;
	
	private List<PhoneNumber> phNumb = new ArrayList<>();
	private List<Medications> medication = new ArrayList<>();
	
	public Pacient() {
		
	}

	public Pacient(String name, Integer rg, Integer cpf, String street, int house, String bairro, String city,
			String state, Date birtDate) {		
		this.name = name;
		this.rg = rg;
		this.cpf = cpf;
		this.street = street;
		this.house = house;
		this.bairro = bairro;
		this.city = city;
		this.state = state;
		this.birtDate = birtDate;
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
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
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

	public Date getBirtDate() {
		return birtDate;
	}

	public List<PhoneNumber> getPhNumb() {
		return phNumb;
	}	

	public List<Medications> getMedication() {
		return medication;
	}
	
	
	
}
