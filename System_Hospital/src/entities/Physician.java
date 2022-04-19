package entities;

import java.io.Serializable;

import entities.abstracts.AllPhy;

public class Physician extends AllPhy implements Serializable {	
	
	private static final long serialVersionUID = 1L;

	public Physician() {
		
	}
	
	public Physician(Integer id, String name, String crm, String specName) {
		super(id, name, crm, specName);		
	}

	@Override
	public String toString() {
		return "Physician [id=" + id + ", name=" + name + ", crm=" + crm + ", specName=" + specName + "]";
	}
	
}
