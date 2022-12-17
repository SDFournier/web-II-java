package com.example.proyecto_manager;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProyectoManagerApplicationTests {

	@Test
	void contextLoads() {
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		String passEncriptado = "Seba99"; //El pass que quieras para el usuario
		System.out.println("PALABRA: " +passEncriptado +" "+pe.encode(passEncriptado));
		
	}

}
