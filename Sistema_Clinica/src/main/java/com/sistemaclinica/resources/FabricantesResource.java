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

import com.sistemaclinica.entities.Fabricantes;
import com.sistemaclinica.services.FabricantesService;

@RestController
@RequestMapping(value = "/fabricantes")
public class FabricantesResource {

	@Autowired
	private FabricantesService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		
		Fabricantes fab = service.findById(id);
		
		return ResponseEntity.ok().body(fab);
		
	}
	
	@RequestMapping(value = "/marcas/{name}", method = RequestMethod.GET)
	public ResponseEntity<?> findByName(@PathVariable String name) {
		
		Fabricantes fab = service.findByName(name);
		
		return ResponseEntity.ok().body(fab);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		
		List<Fabricantes> fabs = service.findAll();
		
		return ResponseEntity.ok().body(fabs);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Fabricantes fab) {
				
		fab = service.insert(fab);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(fab.getId()).toUri();
	
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Fabricantes fab, @PathVariable Integer id) {
		
		fab.setId(id);
		
		fab = service.update(id, fab);
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		
		service.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
}
