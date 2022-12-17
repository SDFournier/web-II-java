package com.example.proyecto_manager.services;

import com.example.proyecto_manager.models.DesarrolladorModelo;
import com.example.proyecto_manager.models.TaskModelo;

import java.util.List;

import com.example.proyecto_manager.entities.Desarrollador;
import com.example.proyecto_manager.entities.Pais;
import com.example.proyecto_manager.entities.Task;
public interface IDesarrolladorService {


	public List<Desarrollador> getAll();




	public DesarrolladorModelo traerPorId(int id);





}