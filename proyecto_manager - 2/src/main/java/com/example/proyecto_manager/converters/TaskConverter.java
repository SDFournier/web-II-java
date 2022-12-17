package com.example.proyecto_manager.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.proyecto_manager.entities.Task;
import com.example.proyecto_manager.models.TaskModelo;

@Component("taskConverter")
public class TaskConverter {
	
	@Autowired
	@Qualifier("avatarConverter")
	private AvatarConverter avatarConverter;

	@Autowired
	@Qualifier("paisConverter")
	private PaisConverter paisConverter;

	public TaskModelo entityToModelSet(Task task) {

		return new TaskModelo(task.getId(), task.getNombre(), task.getTiempo(), task.getProyecto(), task.getPeriodo(), 	avatarConverter.entityToModel(task.getAvatar()), paisConverter.entidadAModeloSet(task.getPaises()));
		

	}
	
	public Task modelToEntitySet(TaskModelo taskModelo) {


		return new Task(taskModelo.getId(), taskModelo.getNombre(), taskModelo.getTiempo(),
				taskModelo.getProyecto(), taskModelo.getPeriodo(), 	avatarConverter.modelToEntity(taskModelo.getAvatar()), 
				paisConverter.modeloAEntidadSet(taskModelo.getPaises()));


	}
	
	public TaskModelo entityToModel(Task task) {
		
		return new TaskModelo(task.getId(), task.getNombre(), task.getTiempo(), task.getProyecto(), task.getPeriodo(), 	avatarConverter.entityToModel(task.getAvatar()));
	
	}



	public Task modelToEntity(TaskModelo taskModelo) {

		return new Task(taskModelo.getId(), taskModelo.getNombre(), taskModelo.getTiempo(), taskModelo.getProyecto(), taskModelo.getPeriodo(), 	avatarConverter.modelToEntity(taskModelo.getAvatar()));


	}
	
	
	//nuevo
	

	

}