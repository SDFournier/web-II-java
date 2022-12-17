package com.example.proyecto_manager.entities;


import javax.persistence.Entity;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;


@Entity
@Table(name="desarrollador")
public class Desarrollador {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;



	private int numero;


	private String nombre;

	@ManyToOne
	@JoinColumn(name = "task_id")
	@JsonBackReference
	private Task task;







	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Desarrollador(int id, int numero, String nombre, Task task) {
		super();
		this.id = id;
		this.numero = numero;
		this.nombre = nombre;
		this.task = task;
	}


	public Desarrollador() {
		super();

	}


	public Desarrollador( int numero, String nombre, Task task) {
		super();

		this.numero = numero;
		this.nombre = nombre;
		this.task = task;
	}

	public Desarrollador(int id, int numero, String nombre) {
		super();
		this.id = id;
		this.numero = numero;
		this.nombre = nombre;

	}


	public Desarrollador( int numero, String nombre) {
		super();

		this.numero = numero;
		this.nombre = nombre;

	}

	@Override
	public String toString() {
		return "Desarrollador [id=" + id + ", numero=" + numero + ", nombre=" + nombre + "]";
	}




}