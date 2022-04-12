package model.dao;

import java.util.List;

import entities.Fabricantes;

public interface FabricantesDao {

	void insert(Fabricantes fab);
	void update(Fabricantes fab);
	void deleteByName(String name);
	Fabricantes findByName(String name);
	List<Fabricantes> findAll();
	
}
