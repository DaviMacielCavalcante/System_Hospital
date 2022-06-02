package com.sistemaclinica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemaclinica.entities.Receitas;

public interface PhysicianRepository extends JpaRepository<Receitas, Integer> {

}
