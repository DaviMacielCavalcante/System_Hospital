package model.dao;

import java.util.List;

import entities.Patient;

public interface PatientDao {

	void insert(Patient fab);
	void update(Patient fab);
	void deleteById(Integer id);
	List<Patient> findAll();
	
}
