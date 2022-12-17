package com.example.proyecto_manager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;


import com.example.proyecto_manager.services.IDesarrolladorService;

@SpringBootTest
public class PrimerPruebaUnitaria {



	@Autowired
	@Qualifier("desarrolladorService")
	private IDesarrolladorService desarrolladorService;

	@Test
	void pruebaDesarrollador1() {

		System.out.println(desarrolladorService.traerPorId(1));
	}






}