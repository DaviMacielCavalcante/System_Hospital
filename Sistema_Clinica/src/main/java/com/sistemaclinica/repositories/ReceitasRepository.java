package com.sistemaclinica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemaclinica.entities.Fabricantes;

public interface ReceitasRepository extends JpaRepository<Fabricantes, Integer> {

}
