package entities;

import entities.abstracts.AllPhy;

public class Physician extends AllPhy {

	
	public Physician() {
		
	}
	
	public Physician(Integer id, String name, String crm, String specName) {
		super(id, name, crm, specName);		
	}		
	
	
	
}
