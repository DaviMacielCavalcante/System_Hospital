package com.sistemaclinica.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	
}
