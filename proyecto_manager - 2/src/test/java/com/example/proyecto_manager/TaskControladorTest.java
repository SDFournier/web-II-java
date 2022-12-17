package com.example.proyecto_manager;

import java.util.List;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.ModelAndView;

import com.example.proyecto_manager.entities.Task;
import com.example.proyecto_manager.controllers.ControladorTask;
import com.example.proyecto_manager.converters.PaisConverter;

import com.example.proyecto_manager.entities.Task;
import com.example.proyecto_manager.services.IAvatarService;

import com.example.proyecto_manager.services.IPaisService;
import com.example.proyecto_manager.services.ITaskService;


public class TaskControladorTest {


	@Autowired
	private ITaskService taskServiceMock = Mockito.mock(ITaskService.class);

	@Autowired
	private IPaisService paisServiceMock= Mockito.mock(IPaisService.class);

	@Autowired
	private IAvatarService avatarServiceMock = Mockito.mock(IAvatarService.class);

	@Autowired
	private ControladorTask taskControladorMock = Mockito.mock(ControladorTask.class);

	@Autowired
	@Qualifier("paisConverter")
	private PaisConverter paisConverter;

	//Antes de cada prueba - Simula la conectividad a la bd
	/*
	@BeforeEach
	void setUp() {
		
		//Respuesta - Mockeado
		Figurita figuritaMock = new Figurita (1,10,"La de Messi");
		ResponseEntity<Object> respuesta = ResponseEntity.status(HttpStatus.OK).body(figuritaMock);
		
		//Primero instanción los objetos
		Mockito.when(controladorMock.traerFigurita(1 )).thenReturn(respuesta);
		
	
	}
	
	*/



	@Test
	void traerTasksService() {

		List<Task> lista = taskServiceMock.getAll();



		Assertions.assertEquals(lista ,  lista);

	}



	@Test
	void traerTasksControlador() {

		ModelAndView lista = taskControladorMock.listaTasks();



		Assertions.assertEquals(lista ,  lista);

	}

}