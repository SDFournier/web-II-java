package com.example.proyecto_manager.controllers.api.v0;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.proyecto_manager.converters.PaisConverter;
import com.example.proyecto_manager.entities.Task;
import com.example.proyecto_manager.services.IAvatarService;
import com.example.proyecto_manager.services.IPaisService;
import com.example.proyecto_manager.services.ITaskService;

import io.swagger.v3.oas.annotations.Operation;

import com.example.proyecto_manager.models.AvatarModelo;
import com.example.proyecto_manager.models.TaskModelo;
import com.example.proyecto_manager.models.request.TaskRequest;

@RestController
@RequestMapping("api/v0/task")
public class TaskControladorRest {


	@Autowired
	@Qualifier("taskService")
	private ITaskService taskService;


	@Autowired
	@Qualifier("paisService")
	private IPaisService paisService;

	@Autowired
	@Qualifier("avatarService")
	private IAvatarService avatarService;


	@Autowired
	@Qualifier("paisConverter")
	private PaisConverter paisConverter;



	@GetMapping("/all")
	public ResponseEntity<List<TaskModelo>> todasLasTasks(){

		List<TaskModelo> tasks = new ArrayList<TaskModelo>();
		tasks.add(new TaskModelo(1,"Stefano", "3 horas", "Proyecto web mercado", "2 semana julio"));
		tasks.add(new TaskModelo(2,"Clarita","5 horas", "Proyecto web peluqueria", "Agosto"));

		return new ResponseEntity<List<TaskModelo>>(tasks, HttpStatus.OK);
		

	}

	@Operation(summary="Eliminar task por id", description = "Elimina a la tasks con su determinado id y todas sus relaciones Avatar, Figurita, Paises")
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Object> eliminarTask(@PathVariable("id") int id) {


	    boolean isRemoved = taskService.remove(id);


	    if (!isRemoved) {
	    	Object body ="No se puedo eliminar";
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
	    }

	    return ResponseEntity.status(HttpStatus.OK).body("Eliminado id: " +id);
	}

	
	@Operation(summary="Trae task por id", description = "Trae a la tasks con su determinado id y todas sus relaciones Avatar, Desarrollador, Paises")
	@GetMapping("/traer/{id}")
	public ResponseEntity<Object> traerTask(@PathVariable("id") int id) {


	    TaskModelo p = taskService.traerPorId(id);
	    Object body;

	    if (p == null) {
	    	body ="No se puedo traer a la task";
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
	    }

	    return ResponseEntity.status(HttpStatus.OK).body(p);
	}


	@Operation(summary="Lista de tasks", description = "Devuelve la lista de tasks con su avatar, sus desarroladores y sus paises candidatos")
	@GetMapping("/listaDeTasks")
	public ResponseEntity<Object> todasLasTasksBD(){

		List<Task> listaTasks = taskService.getAll();

		Object body = "Lista vacia";

		if(listaTasks != null) {
			body = listaTasks;
		}

		return ResponseEntity.status(HttpStatus.OK).body(body);


	}


	@Operation(summary="Agrega una task y su avatar", description = "Seguarda en la base de datos la task y su correspondiente avatar, desarroladores y paises nulos.")
	@PostMapping("/agregarTask")
	public ResponseEntity<Object> agregar(@RequestBody TaskRequest task){

		Object body = "";
		HttpStatus status = HttpStatus.CONFLICT;

		TaskModelo p = new TaskModelo();
		AvatarModelo a = new AvatarModelo();

		a.setEmail(task.getEmail());
		a.setImagen(task.getImagen());
		a.setWebPersonal(task.getWebPersonal());

		p.setTiempo(task.getTiempo());
		p.setNombre(task.getNombre());
		p.setProyecto(task.getProyecto());
		p.setPeriodo(task.getPeriodo());
		p.setAvatar(a);

		
		try {
			 TaskModelo taskAgregada = taskService.insertOrUpdate(p); 
			body = taskAgregada;
			status = HttpStatus.CREATED;
		} catch (Exception e) {
			body = "Error de la excepcion: " + e.getMessage(); 
		}

		return ResponseEntity.status(status).body(body);
	}




	@Operation(summary="Edita una task y su avatar", description = "Se actualizan los datos de la tabla Task y Avatar.")
	@PutMapping("/editarTask/{id}")
	public ResponseEntity<Object> editar(@PathVariable int id, 
			@RequestBody TaskRequest task){


		Object body = "";
		HttpStatus status = HttpStatus.CONFLICT;


		TaskModelo p = taskService.traerPorId(id);

		p.setProyecto(task.getProyecto());
		p.setNombre(task.getNombre());
		p.setPeriodo(task.getPeriodo());
		p.setTiempo(task.getTiempo());
		p.getAvatar().setEmail(task.getEmail());
		p.getAvatar().setWebPersonal(task.getWebPersonal());
		p.getAvatar().setImagen(task.getImagen());


		try {
			 TaskModelo taskAgregada = taskService.insertOrUpdate(p); 
			body = taskAgregada;
			status = HttpStatus.CREATED;
		} catch (Exception e) {
			body = "Error de la excepcion: " + e.getMessage(); 
		}

		return ResponseEntity.status(status).body(body);
	}





}
