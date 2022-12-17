package com.example.proyecto_manager.services;

import com.example.proyecto_manager.models.TaskModelo;

import java.util.List;
import java.util.Set;

import com.example.proyecto_manager.entities.Desarrollador;
import com.example.proyecto_manager.entities.Pais;
import com.example.proyecto_manager.entities.Task;


public interface ITaskService {
	public List<Task> getAll();

	public TaskModelo insertOrUpdate(TaskModelo taskModelo);
	
	public TaskModelo insertOrUpdateSet(TaskModelo taskModelo);

	public boolean remove(int id);
	
	public boolean remove(Long id);
	
	public TaskModelo traerPorId(int id);

	public List<TaskModelo> getAllModel();
	

	public Set<Pais> paisesDeLaTask(int id);

	public Set<Desarrollador> DesarrolladoresDeLaTask(int id);
	
	public List<Task> getTasksCompletas();
	

	public TaskModelo traerTaskCompletaPorId(int id);

}