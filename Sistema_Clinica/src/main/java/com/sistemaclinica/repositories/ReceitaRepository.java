package com.sistemaclinica.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemaclinica.entities.Patient;
import com.sistemaclinica.entities.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Integer> {

	List<Receita> findByPatient(Patient pat);

}
