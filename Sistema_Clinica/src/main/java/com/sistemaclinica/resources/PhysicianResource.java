package com.sistemaclinica.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	
}
