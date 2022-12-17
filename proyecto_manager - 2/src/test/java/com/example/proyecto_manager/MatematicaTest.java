package com.example.proyecto_manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.proyecto_manager.utilidades.Matematica;

public class MatematicaTest {
	@Autowired
	Matematica matematica;

	@Test
	void sumarTest() {

		matematica = new Matematica();


		Assertions.assertEquals(8, matematica.sumar(4, 4));



	}


}