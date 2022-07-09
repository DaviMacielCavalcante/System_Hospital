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

import com.sistemaclinica.entities.Physician;
import com.sistemaclinica.services.PhysicianService;

@RestController
@RequestMapping(value = "/physicians")
public class PhysicianResource {

	@Autowired
	private PhysicianService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		
		Physician phy = service.findById(id);
		
		return ResponseEntity.ok().body(phy);
		
	}
	
	@RequestMapping(value = "/por-nome/{name}", method = RequestMethod.GET)
	public ResponseEntity<?> findByName(@PathVariable String name) {
		
		Physician phy = service.findByName(name);
		
		return ResponseEntity.ok().body(phy);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		
		List<Physician> phys = service.findAll();
		
		return ResponseEntity.ok().body(phys);
	}	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Physician phy) {
				
		phy = service.insert(phy);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(phy.getId()).toUri();
	
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Physician phy, @PathVariable Integer id) {
		
		phy.setId(id);
		
		phy = service.update(id, phy);
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		
		service.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
}
