package com.sistemaclinica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemaclinica.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
