package com.sistemaclinica.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemaclinica.entities.Fabricantes;
import com.sistemaclinica.entities.Medications;

public interface MedicationsRepository extends JpaRepository<Medications, Integer> {

	Optional<Medications> findByName(String name);

	List<Medications> findByFabricantes(Fabricantes fab);
}
