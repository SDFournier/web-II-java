package com.example.proyecto_manager.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.proyecto_manager.converters.PaisConverter;
import com.example.proyecto_manager.converters.TaskConverter;
import com.example.proyecto_manager.entities.Pais;
import com.example.proyecto_manager.entities.Task;
import com.example.proyecto_manager.models.PaisModelo;
import com.example.proyecto_manager.models.TaskModelo;
import com.example.proyecto_manager.repositories.IPaisRepository;
import com.example.proyecto_manager.repositories.ITaskRepository;
import com.example.proyecto_manager.services.IPaisService;
import com.example.proyecto_manager.services.ITaskService;


@Service("paisService")
public class PaisService implements IPaisService {

	@Autowired
	@Qualifier("paisRepository")
	private IPaisRepository paisRepository;

	@Autowired
	@Qualifier("paisConverter")
	private PaisConverter paisConverter;

	@Override
	public List<Pais> getAll(){	


		return paisRepository.findAll();	
	}


	public PaisModelo traerPorId(int id) {


		return paisConverter.entityToModel(paisRepository.findById(id));

	};




	public List<PaisModelo> getAllModel(){

		List<PaisModelo> listaDePaises = new ArrayList<PaisModelo>();

		for (Pais p:getAll() ) {

			listaDePaises.add(paisConverter.entityToModel(p));


		}


		return listaDePaises;
	}

	@Override
	public PaisModelo insertOrUpdate(PaisModelo paisModelo) {



		Pais pais = paisRepository.save(paisConverter.modelToEntity(paisModelo));

		return paisConverter.entityToModel(pais);
	}

	@Override
	public boolean remove(int id) {

		try {
			paisRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}

	}


}