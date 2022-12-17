package com.example.proyecto_manager.integracion;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.servlet.ModelAndView;

import com.example.proyecto_manager.controllers.ControladorTask;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TaskControladorIT {

	@LocalServerPort
	private int port ;

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private ControladorTask controlador;


	@Test
	public void traerTasks() {

		ModelAndView mAV = controlador.listaTasks();


		System.out.println("MODEL" +mAV.getModel());

		assertTrue(controlador!=null);

	}

	@Test
	public void cargarEntorno() throws Exception{
		assertTrue(controlador!=null);
	}

	@Test
	public void greetingShouldReturnDefaultMessage() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/tasks/listaTasks",
				String.class)).contains("CRUD");
	}



}