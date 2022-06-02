package com.sistemaclinica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemaclinica.entities.Medications;

public interface MedicationsRepository extends JpaRepository<Medications, Integer> {

}
