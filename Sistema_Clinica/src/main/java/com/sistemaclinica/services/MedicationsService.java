package com.sistemaclinica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemaclinica.entities.Fabricantes;
import com.sistemaclinica.entities.Medications;
import com.sistemaclinica.repositories.MedicationsRepository;

@Service
public class MedicationsService {

	@Autowired
	private MedicationsRepository repository;
	
	public List<Medications> findAll(){
		return repository.findAll();
	}
	
	public Medications findById(Integer id) {
		Optional<Medications> obj = repository.findById(id);
		return obj.get();
	}
	
	public Medications findByName(String name) {
		Optional<Medications> obj = repository.findByName(name);
		return obj.get();
	}
	
	public List<Medications> findByFabricantes(Fabricantes fab) {
		List<Medications> list = repository.findByFabricantes(fab);		
		return list;
	}
	
	public Medications insert(Medications phy) {
		return repository.save(phy);
	}
	
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
	
	public Medications update(Integer id, Medications obj) {
		Medications entity = findById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}
	
	private void updateData(Medications entity, Medications obj) {
		entity.setId(obj.getId());
		entity.setName(obj.getName());
		entity.setDose(obj.getDose());		
	}
	
}
