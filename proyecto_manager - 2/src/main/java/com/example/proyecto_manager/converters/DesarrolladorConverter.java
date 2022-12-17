package com.example.proyecto_manager.converters;



import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.example.proyecto_manager.entities.Desarrollador;
import com.example.proyecto_manager.models.DesarrolladorModelo;



@Component("desarrolladorConverter")
public class DesarrolladorConverter {



	public DesarrolladorModelo entityToModel(Desarrollador desarrollador) {



		return new DesarrolladorModelo(desarrollador.getId(), desarrollador.getNumero(), desarrollador.getNombre());


	}



	public Desarrollador modelToEntity(DesarrolladorModelo desarrollador) {


		return new Desarrollador(desarrollador.getId(), desarrollador.getNumero(), desarrollador.getNombre());


	}

}