package com.sistemaclinica.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	
}
