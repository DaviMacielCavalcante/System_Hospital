package com.sistemaclinica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemaclinica.entities.Patient;
import com.sistemaclinica.entities.Receitas;
import com.sistemaclinica.repositories.ReceitasRepository;

@Service
public class ReceitasService {

	@Autowired
	private ReceitasRepository repository;
	
	public List<Receitas> findAll(){
		return repository.findAll();
	}
	
	public Receitas findById(Integer id) {
		Optional<Receitas> obj = repository.findById(id);
		return obj.get();
	}	
	
	public List<Receitas> findByPatient(Patient pat) {
		List<Receitas> list = repository.findByPatient(pat);		
		return list;
	}
	
	public Receitas insert(Receitas phy) {
		return repository.save(phy);
	}
	
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
	
	public Receitas update(Integer id, Receitas obj) {
		Receitas entity = findById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}
	
	private void updateData(Receitas entity, Receitas obj) {
		entity.setId(obj.getId());
		entity.setPhysician(obj.getPhysician());
		entity.setPatient(obj.getPatient());
		entity.setMedications(obj.getMedications());
	}
	
}
