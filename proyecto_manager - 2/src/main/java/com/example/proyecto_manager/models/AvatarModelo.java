package com.example.proyecto_manager.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class AvatarModelo {


	private int id;

	private String imagen;
	
	@Email
	@Size(min=10, max =20)
	private String email;

	@Size(min=5, max =40)
	private String webPersonal;

	private TaskModelo task;





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
	public AvatarModelo(int id, String email, String webPersonal) {
		super();
		this.id = id;
		this.email = email;
		this.webPersonal = webPersonal;
	}



	public AvatarModelo() {
		super();

	}
	public TaskModelo getTask() {
		return task;
	}
	public void setTask(TaskModelo task) {
		this.task = task;
	}
	public AvatarModelo(int id, @Email @Size(min = 10, max = 20) String email,
			@Size(min = 5, max = 40) String webPersonal, TaskModelo task) {
		super();
		this.id = id;
		this.email = email;
		this.webPersonal = webPersonal;
		this.task = task;
	}

	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public AvatarModelo(int id, @Email @Size(min = 10, max = 20) String email,
			@Size(min = 5, max = 40) String webPersonal, String imagen, TaskModelo task) {
		super();
		this.id = id;
		this.email = email;
		this.webPersonal = webPersonal;
		this.imagen = imagen;
		this.task = task;
	}

	
	public AvatarModelo(int id, @Email @Size(min = 10, max = 20) String email,
			@Size(min = 5, max = 40) String webPersonal, String imagen) {
		super();
		this.id = id;
		this.email = email;
		this.webPersonal = webPersonal;
		this.imagen = imagen;

	}
	@Override
	public String toString() {
		return "AvatarModelo [id=" + id + ", email=" + email + ", webPersonal=" + webPersonal + ", imagen=" + imagen
				+ ", task=" + task + "]";
	}

}