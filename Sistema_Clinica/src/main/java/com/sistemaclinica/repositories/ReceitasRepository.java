package com.sistemaclinica.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemaclinica.entities.Patient;
import com.sistemaclinica.entities.Receitas;

public interface ReceitasRepository extends JpaRepository<Receitas, Integer> {

	List<Receitas> findByPatient(Patient pat);

}
