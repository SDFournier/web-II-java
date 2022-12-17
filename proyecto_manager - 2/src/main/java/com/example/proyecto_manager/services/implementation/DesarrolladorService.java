package com.example.proyecto_manager.services.implementation;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.proyecto_manager.repositories.IDesarrolladorRepository;
import com.example.proyecto_manager.services.IDesarrolladorService;
import com.example.proyecto_manager.converters.DesarrolladorConverter;
import com.example.proyecto_manager.entities.Desarrollador;
import com.example.proyecto_manager.models.DesarrolladorModelo;




@Service("desarrolladorService")
public class DesarrolladorService implements IDesarrolladorService {

	@Autowired
	@Qualifier("desarrolladorRepository")
	private IDesarrolladorRepository desarrolladorRepository;

	@Autowired
	@Qualifier("desarrolladorConverter")
	private DesarrolladorConverter desarrolladorConverter;

	@Override
	public List<Desarrollador> getAll(){	


		return desarrolladorRepository.findAll();	
	}


	public DesarrolladorModelo traerPorId(int id) {


		return desarrolladorConverter.entityToModel(desarrolladorRepository.findById(id));

	};




}