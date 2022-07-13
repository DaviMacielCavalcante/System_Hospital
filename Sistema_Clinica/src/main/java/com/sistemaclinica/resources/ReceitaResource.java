package com.sistemaclinica.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sistemaclinica.entities.Receita;
import com.sistemaclinica.resources.utils.URL;
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
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findbyPatient(
			@RequestParam(value = "patients", defaultValue = "") String patients){
		
		List<Integer> ids = URL.decodeIntList(patients);
		
		List<Receita> list = service.searchByPat(ids);			
		
		return ResponseEntity.ok().body(list);
		
	}	
	
	@RequestMapping(value = "/all" , method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		
		List<Receita> recs = service.findAll();
		
		return ResponseEntity.ok().body(recs);
	}	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Receita rec) {
				
		rec = service.insert(rec);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(rec.getId()).toUri();
	
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Receita rec, @PathVariable Integer id) {
		
		rec.setId(id);
		
		rec = service.update(id, rec);
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		
		service.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
}
