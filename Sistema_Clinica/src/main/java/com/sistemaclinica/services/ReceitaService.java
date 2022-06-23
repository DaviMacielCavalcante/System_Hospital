package com.sistemaclinica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemaclinica.entities.Patient;
import com.sistemaclinica.entities.Receita;
import com.sistemaclinica.repositories.ReceitaRepository;

@Service
public class ReceitaService {

	@Autowired
	private ReceitaRepository repository;
	
	public List<Receita> findAll(){
		return repository.findAll();
	}
	
	public Receita findById(Integer id) {
		Optional<Receita> obj = repository.findById(id);
		return obj.get();
	}	
	
	public List<Receita> findByPatient(Patient pat) {
		List<Receita> list = repository.findByPatient(pat);		
		return list;
	}
	
	public Receita insert(Receita phy) {
		return repository.save(phy);
	}
	
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
	
	public Receita update(Integer id, Receita obj) {
		Receita entity = findById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}
	
	private void updateData(Receita entity, Receita obj) {
		entity.setId(obj.getId());
		entity.setPhysician(obj.getPhysician());
		entity.setPatient(obj.getPatient());
		entity.setMedications(obj.getMedications());
	}
	
}
