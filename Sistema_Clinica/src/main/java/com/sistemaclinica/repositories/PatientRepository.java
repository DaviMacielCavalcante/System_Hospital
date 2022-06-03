package com.sistemaclinica.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemaclinica.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

	Optional<Patient> findByName(String name);

	Optional<Patient> findByCpf(String cpf);

}
