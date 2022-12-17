package com.example.proyecto_manager.models;




import java.util.HashSet;

import java.util.Set;




public class PaisModelo {



	private int id;



	private String nombre;

	private int ranking;


	public Set<TaskModelo> task = new HashSet<>();


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


	public void setRanking(int ranking) {
		this.ranking = ranking;
	}


	public Set<TaskModelo> getTask() {
		return task;
	}


	public void setTask(Set<TaskModelo> task) {
		this.task = task;
	}


	public PaisModelo(int id, String nombre, int ranking, Set<TaskModelo> task) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ranking = ranking;
		this.task = task;
	}


	public PaisModelo(int id, String nombre, int ranking) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ranking = ranking;
		this.task= new HashSet<>();
	}


	public PaisModelo() {
		super();


	}








}