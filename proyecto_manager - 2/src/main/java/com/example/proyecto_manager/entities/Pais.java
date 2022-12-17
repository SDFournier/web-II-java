package com.example.proyecto_manager.entities;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true) //Para hacer iguales los objetos
@Table(name="pais")
public class Pais {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;



	private String nombre;

	private int ranking;



	 @ManyToMany(mappedBy = "paises")
	 @JsonIgnoreProperties("paises")
	    public Set<Task> task = new HashSet<>();




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int rank) {
		this.ranking = rank;
	}





	public Pais() {
		super();

	}

	public Pais(int id, String nombre, int ranking, Set<Task> task) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ranking = ranking;
		this.task = task;
	}
	
	public Pais(int id, String nombre, int ranking) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ranking = ranking;
		this.task =  new HashSet<>();
	}

	public Set<Task> getTask() {
		return task;
	}

	public void setTask(Set<Task> task) {
		this.task = task;
	}

	@Override
	public String toString() {
		return "Pais [id=" + id + ", nombre=" + nombre + ", ranking=" + ranking + "]";
	}



}