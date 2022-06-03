package com.sistemaclinica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemaclinica.entities.Physician;
import com.sistemaclinica.repositories.PhysicianRepository;

@Service
public class PhysicianService {

	@Autowired
	private PhysicianRepository repository;
	
	public List<Physician> findAll(){
		return repository.findAll();
	}
	
	public Physician findById(Integer id) {
		Optional<Physician> obj = repository.findById(id);
		return obj.get();
	}
	
	public Physician findByName(String name) {
		Optional<Physician> obj = repository.findByName(name);
		return obj.get();
	}
	
	public Physician insert(Physician phy) {
		return repository.save(phy);
	}
	
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
	
	public Physician update(Integer id, Physician obj) {
		Physician entity = findById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}
	
	private void updateData(Physician entity, Physician obj) {
		entity.setId(obj.getId());
		entity.setName(obj.getName());
		entity.setCrm(obj.getCrm());
		entity.setSpecName(obj.getSpecName());
	}
	
}
