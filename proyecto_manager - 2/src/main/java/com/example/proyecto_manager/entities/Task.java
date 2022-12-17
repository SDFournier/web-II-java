package com.example.proyecto_manager.entities;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

//for relations to many etc
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import lombok.EqualsAndHashCode;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="task")
public class Task {

	//columnas que no estan en models
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	//Las mismas de la capa models:
	@Column(name="nombre")
	private String nombre;

	@Column(name="tiempo")
	private String tiempo;

	@Column(name="proyecto")
	private String proyecto;
	
	@Column(name="periodo")
	private String periodo;
	
	//Nuevas que se suelen usar
	@Column(name="creado")
	@CreationTimestamp
	private LocalDateTime createdAt;

	@Column(name="actualizado")
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	
	//Se podria agregar @NotNull si se queire que la relación exista siempre
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "avatar_id", referencedColumnName = "id")
	@JsonIgnore
	private Avatar avatar;

	
	//relations 
	@OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<Desarrollador> desarrolladores = new HashSet<>();


	 @ManyToMany(cascade = {
	            CascadeType.PERSIST,
	            CascadeType.MERGE
	  })
	    @JoinTable(name = "task_pais",
	            joinColumns = @JoinColumn(name = "task_id"),
	            inverseJoinColumns = @JoinColumn(name = "pais_id")
	  )
	 @JsonIgnoreProperties("task")
	private Set<Pais> paises = new HashSet<>();
	




	public Task(int id, String nombre, String proyecto, String tiempo, String periodo, LocalDateTime createdAt,
			LocalDateTime updatedAt, Avatar avatar, Set<Pais> paises) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.proyecto = proyecto;
		this.tiempo = tiempo;
		this.periodo = periodo;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.avatar = avatar;
		this.paises = paises;
	}
	
	public Task(int id, String nombre, String proyecto, String tiempo, String periodo, Avatar avatar, Set<Pais> paises) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.proyecto = proyecto;
		this.tiempo = tiempo;
		this.periodo = periodo;
		this.avatar = avatar;
		this.paises = paises;
	}




	public Task(int id, String nombre, String proyecto, String tiempo, String periodo, LocalDateTime createdAt,
			LocalDateTime updatedAt, Avatar avatar) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.proyecto = proyecto;
		this.tiempo = tiempo;
		this.periodo = periodo;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.avatar = avatar;

	}

	//setters for the relations
	public Set<Desarrollador> getDesarrolladores() {
		return desarrolladores;
	}



	public void setDesarrolladores(Set<Desarrollador> desarrolladores) {
		this.desarrolladores = desarrolladores;
	}

	public Set<Pais> getPaises() {
		return paises;
	}



	public void setPaises(Set<Pais> paises) {
		this.paises = paises;
	}



	public Task(int id, String nombre, String proyecto, String periodo, String tiempo, LocalDateTime createdAt,
			LocalDateTime updatedAt, Avatar avatar, Set<Desarrollador> desarrolladores,Set<Pais> paises) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.proyecto =proyecto;
		this.periodo = periodo;
		this.tiempo = tiempo;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.avatar = avatar;
		this.desarrolladores = desarrolladores;
		this.paises = paises;
	}



/////////
	
	
	
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public Task(int id, String nombre, String tiempo, String proyecto, String periodo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tiempo = tiempo;
		this.proyecto = proyecto;
		this.periodo = periodo;
		
	}
	public Task(int id, String nombre, String tiempo, String proyecto, String periodo, Avatar avatar) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tiempo = tiempo;
		this.proyecto = proyecto;
		this.periodo = periodo;
		this.avatar = avatar;
	}

	public Avatar getAvatar() {
		return avatar;
	}
	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}

	public Task() {
		super();
	}
	
	@Override
	public String toString() {
		return "Task [id=" + id + ", nombre=" + nombre + ", proyecto=" + proyecto + ", tiempo=" + tiempo + ", periodo=" + periodo
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ "]";
	}
	

}