package com.example.proyecto_manager.models;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class TaskModelo {

	private int id;
	@Size(min=4, max =12)
	private String nombre;
	@Size(min=4, max =15)
	private String tiempo;
	@Size(min=4, max =15)
	private String proyecto;
	@Size(min=4, max =15)
	private String periodo;
	private AvatarModelo avatar;

	private Set<PaisModelo> paises = new HashSet<>();
	
	public TaskModelo() 
	{
		super();
	}


	public TaskModelo(@Size(min = 4, max = 12) String nombre,@Size(min=4, max =15) String tiempo,@Size(min=4, max =15) String proyecto, @Size(min=4, max =15) String periodo) {
		super();
		this.nombre = nombre;
		this.tiempo = tiempo;
		this.proyecto = proyecto;
		this.periodo = periodo;
	}
	
	//lo agregue yo
	public TaskModelo(int id, @Size(min = 4, max = 12) String nombre,@Size(min=4, max =15) String tiempo,@Size(min=4, max =15) String proyecto, @Size(min=4, max =15) String periodo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tiempo = tiempo;
		this.proyecto = proyecto;
		this.periodo = periodo;
	}
	//

	public TaskModelo(int id, @Size(min = 4, max = 12) String nombre,@Size(min=4, max =15) String tiempo,
			@Size(min=4, max =15) String proyecto, @Size(min=4, max =15) String periodo, AvatarModelo avatar, Set<PaisModelo> paises)  {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tiempo = tiempo;
		this.proyecto = proyecto;
		this.periodo = periodo;
		this.avatar = avatar;
		this.paises = paises;
	}

	@Override
	public String toString() {
		return "TaskModelo [nombre=" + nombre + ", tiempo=" + tiempo + ", proyecto=" + proyecto  + ", periodo=" + periodo +", avatar=" + avatar + "]";
	}

	
	public TaskModelo(int id, @Size(min = 4, max = 12) String nombre,@Size(min=4, max =15) String tiempo,@Size(min=4, max =15) String proyecto, @Size(min=4, max =15) String periodo, AvatarModelo avatar) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tiempo = tiempo;
		this.proyecto = proyecto;
		this.periodo = periodo;
		this.avatar = avatar;
	}
	
	
	public Set<PaisModelo> getPaises() {
		return paises;
	}


	public void setPaises(Set<PaisModelo> paises) {
		this.paises = paises;
	}
	
	public AvatarModelo getAvatar() {
		return avatar;
	}


	public void setAvatar(AvatarModelo avatar) {
		this.avatar = avatar;
	}
	
	
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
	public String getTiempo() {
		return tiempo;
	}
	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}
	public String getProyecto() {
		return proyecto;
	}
	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}
	
	public String getPeriodo() {
		return periodo;
	}


	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}




}
