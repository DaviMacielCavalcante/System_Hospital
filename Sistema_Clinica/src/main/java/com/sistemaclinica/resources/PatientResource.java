package com.sistemaclinica.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sistemaclinica.entities.Patient;
import com.sistemaclinica.services.PatientService;

@RestController
@RequestMapping(value = "/patients")
public class PatientResource {

	@Autowired
	private PatientService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		
		Patient pat = service.findById(id);
		
		return ResponseEntity.ok().body(pat);
		
	}
	
	@RequestMapping(value = "/por-nome/{name}", method = RequestMethod.GET)
	public ResponseEntity<?> findByName(@PathVariable String name) {
		
		Patient pat = service.findByName(name);
		
		return ResponseEntity.ok().body(pat);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		
		List<Patient> pats = service.findAll();
		
		return ResponseEntity.ok().body(pats);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Patient pat) {
				
		pat = service.insert(pat);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pat.getId()).toUri();
	
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Patient pat, @PathVariable Integer id) {
		
		pat.setId(id);
		
		pat = service.update(id, pat);
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		
		service.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}	
}
