package com.example.proyecto_manager.services.implementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.proyecto_manager.converters.TaskConverter;
//import com.example.proyecto_manager.converters.TaskConverter;
import com.example.proyecto_manager.entities.Task;
import com.example.proyecto_manager.entities.Avatar;
import com.example.proyecto_manager.entities.Desarrollador;
import com.example.proyecto_manager.entities.Pais;
import com.example.proyecto_manager.models.TaskModelo;
import com.example.proyecto_manager.repositories.IAvatarRepository;
import com.example.proyecto_manager.repositories.ITaskRepository;
import com.example.proyecto_manager.services.ITaskService;


@Service("taskService")
public class TaskService implements ITaskService {
	
	@Autowired
	@Qualifier("taskRepository")
	private ITaskRepository taskRepository;

	@Autowired
	@Qualifier("taskConverter")
	private TaskConverter taskConverter;

	@Autowired
	@Qualifier("avatarRepository")
	private IAvatarRepository avatarRepository;
	
	@Override
	public List<Task> getAll(){	
		return taskRepository.findAll();	
	}
	
	public TaskModelo traerPorId(int id) {


		return taskConverter.entityToModel(taskRepository.findById(id));

	};
	
	public TaskModelo traerTaskCompletaPorId(int id) {

		List<Task> listaEntidad = getTasksCompletas();
		TaskModelo taskEncontrada = new TaskModelo();
		for (Task p: listaEntidad) {

			if(p.getId() == id) {

				taskEncontrada = taskConverter.entityToModel(p);

			}


		}
		return taskEncontrada;
	}

	public List<Task> getTasksCompletas(){

		List<Task> tasks = getAll();

		for (Task p: tasks) {

			Avatar avatar = avatarRepository.findById(p.getAvatar().getId());


			Set<Pais> paises = paisesDeLaTask(p.getId());
			Set<Desarrollador> desarrolladores = DesarrolladoresDeLaTask(p.getId());

			if(avatar != null) {
				p.setAvatar(avatar);
			}


			if(paises!=null) {
			p.setPaises(paises);
			}

			if(desarrolladores!=null) {
			p.setDesarrolladores(desarrolladores);
			}
		}

		return tasks;
	}
	

	public List<TaskModelo> getAllModel(){

		List<TaskModelo> listaDeTasks = new ArrayList<TaskModelo>();

		for (Task p:getAll() ) {

			listaDeTasks.add(taskConverter.entityToModel(p));


		}


		return listaDeTasks;
	}
	@Override
	public TaskModelo insertOrUpdate(TaskModelo taskModelo) {
//se genera una clase co nvertidaora para pasar lo que le pasa el controlador que es u nOBJETO de la clase task para pasarlo a  entity que es con l oque trabaj la BD
		Task task = taskRepository.save(taskConverter.modelToEntity(taskModelo));

		return taskConverter.entityToModel(task);
	}

	@Override
	public boolean remove(int id) {

		try {
			taskRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}

	}

	
	
	public Set<Pais> paisesDeLaTask(int id) {
		
		System.out.println("--------------> ID : " + id );
		
		Task p = taskRepository.findByIdAndFetchPaisesEagerly(id);
		
		System.out.println("--------------> P DE findByIdAndFetchPaisesEagerly : " + p );

		Set<Pais> lista = new HashSet<>();

		if (p!=null) {
			if(p.getPaises()!=null) {
				lista = p.getPaises();
			}
		}
		
		System.out.println("--------------> ID : " + lista );
		
		return lista;
	}


	public Set<Desarrollador> DesarrolladoresDeLaTask(int id) {

		Task p = taskRepository.findByIdAndFetchDesarrolladoresEagerly(id);

		Set<Desarrollador> lista = new HashSet<>();

		if (p!=null) {
			if(p.getDesarrolladores()!=null) {
					lista = p.getDesarrolladores();
			}
		}

		return lista;
	}


	@Override
	public TaskModelo insertOrUpdateSet(TaskModelo taskModelo) {



		Task task = taskRepository.save(taskConverter.modelToEntitySet(taskModelo));

		return taskConverter.entityToModelSet(task);
	}
	
	@Override
	public boolean remove(Long id) {

		try {
			taskRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}

	}

}