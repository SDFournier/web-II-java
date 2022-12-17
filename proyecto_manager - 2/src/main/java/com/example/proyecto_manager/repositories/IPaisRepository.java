package com.example.proyecto_manager.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.proyecto_manager.entities.Pais;
import com.example.proyecto_manager.entities.Task;

@Repository("paisRepository")
public interface IPaisRepository extends 
						JpaRepository<Pais, Serializable> {


	public abstract Pais findByNombre(String nombre);

	public abstract Pais findById(int id);





}