package com.example.proyecto_manager;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import com.example.proyecto_manager.controllers.api.v0.DesarrolladorControladorRest;
import com.example.proyecto_manager.entities.Desarrollador;
import com.example.proyecto_manager.services.IDesarrolladorService;



///Usaremos Mockito :) Comportamiento sin conectar a base de datos, para que no sea de integración


public class DesarrolladorControladorTest {

	@Autowired
	@Qualifier("desarrolladorService")
	private IDesarrolladorService desarrolladorService;

	//DesarrolladorRepository desarrolladorRepocitoryMock = Mockito.mock(DesarrolladorRepository.class);

	@Autowired
	DesarrolladorControladorRest controladorMock = Mockito.mock(DesarrolladorControladorRest.class);

	//Antes de cada prueba - Simula la conectividad a la bd
	@BeforeEach
	void setUp() {

		//Respuesta - Mockeado
		Desarrollador desarrolladorMock = new Desarrollador (1,10,"Lionel Messi");
		ResponseEntity<Object> respuesta = ResponseEntity.status(HttpStatus.OK).body(desarrolladorMock);

		//Primero instanción los objetos
		Mockito.when(controladorMock.traerDesarrollador(1 )).thenReturn(respuesta);


		//Respuesta - Mockeado
		desarrolladorMock = null;
		respuesta = ResponseEntity.status(HttpStatus.NO_CONTENT).body(desarrolladorMock);

		//Primero instanción los objetos
		Mockito.when(controladorMock.traerDesarrollador(100 )).thenReturn(respuesta);
	}


	@Test
	void traerDesarrollador() {

		ResponseEntity<Object> respuesta;

		respuesta = controladorMock.traerDesarrollador(1);

		Assertions.assertEquals(10,  ((Desarrollador) (respuesta.getBody())).getNumero());

	}

	@Test
	void traerDesarrolladorErronea() {

		ResponseEntity<Object> respuesta;

		respuesta = controladorMock.traerDesarrollador(100);

		Assertions.assertEquals(null,  ((Desarrollador) (respuesta.getBody())));

	}

}