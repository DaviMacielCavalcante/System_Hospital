package com.sistemaclinica.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemaclinica.entities.Physician;

public interface PhysicianRepository extends JpaRepository<Physician, Integer> {	

	Optional<Physician> findByName(String name);

}
