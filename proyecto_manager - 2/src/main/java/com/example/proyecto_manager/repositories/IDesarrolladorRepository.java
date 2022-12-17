package com.example.proyecto_manager.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.proyecto_manager.entities.Desarrollador;
import com.example.proyecto_manager.entities.Pais;
import com.example.proyecto_manager.entities.Task;

@Repository("desarrolladorRepository")
public interface IDesarrolladorRepository extends 
						JpaRepository<Desarrollador, Serializable> {




	public abstract Desarrollador findById(int id);





}