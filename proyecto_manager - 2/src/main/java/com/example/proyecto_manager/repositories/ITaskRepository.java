package com.example.proyecto_manager.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.proyecto_manager.entities.Task;


@Repository("taskRepository")
public interface ITaskRepository extends 
						JpaRepository<Task, Serializable> {

	//Metodos que se pueden llamar desde el controlador :) 
	//Si se utilizan nombres standar como findBy, Order, GroupBy, etc no hace falta 
	//desarrollar las consultas,tambien se puede hacer buscarPorNombre, pero
	//con esos nombres deberas programarlo personalmente
	public abstract Task findByNombre(String nombre);


	public abstract Task findById(int id);


	public abstract Task findByProyectoAndPeriodo(String pais, String periodo);

	
	public abstract Task findByProyectoAndPeriodoOrderByPeriodoDesc(String proyecto, String periodo);
	
	
	@Query("SELECT  p FROM Task p JOIN FETCH p.paises WHERE p.id = (:id)")
	public abstract Task findByIdAndFetchPaisesEagerly(@Param("id") int id);


	@Query("SELECT  p FROM Task p JOIN FETCH p.desarrolladores WHERE p.id = (:id)")
	public abstract Task findByIdAndFetchDesarrolladoresEagerly(@Param("id") int id);
	

}