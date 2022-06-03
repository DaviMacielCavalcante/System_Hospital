package com.sistemaclinica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemaclinica.entities.Patient;
import com.sistemaclinica.repositories.PatientRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository repository;
	
	public List<Patient> findAll(){
		return repository.findAll();
	}
	
	public Patient findById(Integer id) {
		Optional<Patient> obj = repository.findById(id);
		return obj.get();
	}
	
	public Patient findByName(String name) {
		Optional<Patient> obj = repository.findByName(name);
		return obj.get();
	}
	
	public Patient findByCpf(String cpf) {
		Optional<Patient> obj = repository.findByCpf(cpf);
		return obj.get();
	}
	
	public Patient insert(Patient pat) {
		return repository.save(pat);
	}
	
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
	
	public Patient update(Integer id, Patient obj) {
		Patient entity = findById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}
	
	private void updateData(Patient entity, Patient obj) {
		entity.setId(obj.getId());
		entity.setName(obj.getName());
	}
	
}
