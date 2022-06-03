package com.sistemaclinica.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemaclinica.entities.Fabricantes;

public interface FabricantesRepository extends JpaRepository<Fabricantes, Integer>{

	Optional<Fabricantes> findByName(String name);
	
}
