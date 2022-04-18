package model.dao;

import java.util.List;

import entities.Receita;

public interface ReceitaDao {

	void insert(Receita rec);
	void deleteById(Integer id);
	Receita findByPatName(String name);	
	List<Receita> findAll();
}
