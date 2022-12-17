package com.example.proyecto_manager.models.request;



import com.fasterxml.jackson.annotation.JsonProperty;

public class TaskRequest {
	
	@JsonProperty("Nombre")
	private String nombre;

	@JsonProperty("Tiempo")
	private String tiempo;

	@JsonProperty("Proyecto")
	private String proyecto;

	@JsonProperty("Periodo")
	private String periodo;

	//DATOS AVATAR
	@JsonProperty("Email")
	private String email;


	@JsonProperty("WebPersonal")
	private String webPersonal;

	@JsonProperty("Imagen")
	private String imagen;

	//Constructores, setters y getters


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProyecto() {
		return proyecto;
	}

	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}

	public String getTiempo() {
		return tiempo;
	}

	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public TaskRequest(  String nombre,  String proyecto,
			String tiempo, String periodo) {
		super();

		this.nombre = nombre;
		this.proyecto = proyecto;
		this.tiempo = tiempo;
		this.periodo = periodo;
	}



	@Override
	public String toString() {
		return "PersonaRequest [nombre=" + nombre + ", proyecto=" + proyecto + ", tiempo=" + tiempo + ", periodo=" + periodo + ", email="
				+ email + ", webPersonal=" + webPersonal + ", imagen=" + imagen + "]";
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

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public TaskRequest(String nombre, String proyecto, String tiempo, String periodo,
			String email,String webPersonal, String imagen) {
		super();
		this.nombre = nombre;
		this.proyecto = proyecto;
		this.tiempo = tiempo;
		this.periodo = periodo;
		this.email = email;
		this.webPersonal = webPersonal;
		this.imagen = imagen;
	}

	public TaskRequest() {
		super();
	}







}