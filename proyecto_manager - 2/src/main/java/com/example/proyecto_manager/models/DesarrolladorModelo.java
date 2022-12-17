package com.example.proyecto_manager.models;






public class DesarrolladorModelo {



	private int id;



	private int numero;


	private String nombre;









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





	public DesarrolladorModelo() {
		super();

	}




	public DesarrolladorModelo(int id, int numero, String nombre) {
		super();
		this.id = id;
		this.numero = numero;
		this.nombre = nombre;

	}


	public DesarrolladorModelo( int numero, String nombre) {
		super();

		this.numero = numero;
		this.nombre = nombre;

	}

	@Override
	public String toString() {
		return "Desarrollador [id=" + id + ", numero=" + numero + ", nombre=" + nombre + "]";
	}






}