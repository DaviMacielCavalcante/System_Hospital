package com.sistemaclinica.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.sistemaclinica.entities.Patient;
import com.sistemaclinica.entities.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Integer> {

	@Transactional(readOnly = true)
	@Query("SELECT DISTINCT obj FROM Receita obj INNER JOIN obj.patient WHERE obj.patient IN :patient")
	List<Receita> search(@Param("patient") List<Patient> patient);
}
