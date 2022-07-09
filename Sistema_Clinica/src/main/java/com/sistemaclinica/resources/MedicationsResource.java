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

import com.sistemaclinica.entities.Medications;
import com.sistemaclinica.services.MedicationsService;

@RestController
@RequestMapping(value = "/medications")
public class MedicationsResource {

	@Autowired
	private MedicationsService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		
		Medications med = service.findById(id);
		
		return ResponseEntity.ok().body(med);
		
	}
	
	@RequestMapping(value = "/por-nome/{name}", method = RequestMethod.GET)
	public ResponseEntity<?> findByName(@PathVariable String name) {
		
		Medications med = service.findByName(name);
		
		return ResponseEntity.ok().body(med);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		
		List<Medications> meds = service.findAll();
		
		return ResponseEntity.ok().body(meds);
	}	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Medications med) {
				
		med = service.insert(med);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(med.getId()).toUri();
	
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Medications med, @PathVariable Integer id) {
		
		med.setId(id);
		
		med = service.update(id, med);
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		
		service.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
}
