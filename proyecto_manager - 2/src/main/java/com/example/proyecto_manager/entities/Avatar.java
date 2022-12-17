package com.example.proyecto_manager.entities;

import javax.persistence.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="avatar")
public class Avatar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	
	private int id;
	
	private String imagen;
	

	private String email;

	private String webPersonal;

	//Relación no propietaria
	@OneToOne(mappedBy = "avatar")
	@JsonIgnore
	private Task task;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWebPersonal() {
		return webPersonal;
	}
	public void setWebPersonal(String webPersonal) {
		this.webPersonal = webPersonal;
	}
	public Avatar(int id, String email, String webPersonal) {
		super();
		this.id = id;
		this.email = email;
		this.webPersonal = webPersonal;
	}
	public Avatar(int id, String email, String webPersonal, String imagen) {
		super();
		this.id = id;
		this.email = email;
		this.webPersonal = webPersonal;
		this.imagen = imagen;

	}
	public Avatar() {
		super();

	}
	@Override
	public String toString() {
		return "Avatar [id=" + id + ", email=" + email + ", webPersonal=" + webPersonal + ", imagen=" + imagen + "]";
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}

}