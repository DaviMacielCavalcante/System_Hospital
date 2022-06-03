package com.sistemaclinica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemaclinica.entities.Fabricantes;
import com.sistemaclinica.repositories.FabricantesRepository;

@Service
public class FabricantesService {

	@Autowired
	private FabricantesRepository repository;
	
	public List<Fabricantes> findAll(){
		return repository.findAll();
	}
	
	public Fabricantes findById(Integer id) {
		Optional<Fabricantes> obj = repository.findById(id);
		return obj.get();
	}
	
	public Fabricantes findByName(String name) {
		Optional<Fabricantes> obj = repository.findByName(name);
		return obj.get();
	}
	
	public Fabricantes insert(Fabricantes fab) {
		return repository.save(fab);
	}
	
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
	
	public Fabricantes update(Integer id, Fabricantes obj) {
		Fabricantes entity = findById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}
	
	private void updateData(Fabricantes entity, Fabricantes obj) {
		entity.setId(obj.getId());
		entity.setName(obj.getName());
	}
	
}
