package model.dao;

import java.util.List;

import entities.Fabricantes;
import entities.Medications;

public interface MedicationsDao {

	void insert(Medications fab);
	void update(Medications fab);
	void deleteById(Integer id);
	Medications findByName(String name);
	List<Medications> findAll();
	Medications findByFabricantes(Fabricantes fab);
}
