package com.sistemaclinica.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sistemaclinica.entities.Receita;
import com.sistemaclinica.services.ReceitaService;

@RestController
@RequestMapping(value = "/receitas")
public class ReceitaResource {

	@Autowired
	private ReceitaService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		
		Receita rec = service.findById(id);
		
		return ResponseEntity.ok().body(rec);
		
	}
	
}
