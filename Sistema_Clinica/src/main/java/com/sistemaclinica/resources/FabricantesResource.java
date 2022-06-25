package com.sistemaclinica.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	
}
