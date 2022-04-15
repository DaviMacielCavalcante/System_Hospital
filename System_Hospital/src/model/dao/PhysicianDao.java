package model.dao;

import entities.Physician;

public interface PhysicianDao {

	void insert(Physician phy);
	void update(Physician phy);
	void deleteById(Integer id);	

}
