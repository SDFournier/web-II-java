package com.example.proyecto_manager.controllers.api.v0;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.proyecto_manager.models.DesarrolladorModelo;
import com.example.proyecto_manager.services.IDesarrolladorService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("api/v0/desarrollador")
public class DesarrolladorControladorRest {

	@Autowired
	@Qualifier("desarrolladorService")
	private IDesarrolladorService desarrolladorService;


	@Operation(summary="Trae figurita por id", description = "Trae a la desarrollador con su determinado id")
	@GetMapping("/traer/{id}")
	public ResponseEntity<Object> traerDesarrollador(@PathVariable("id") int id) {


		DesarrolladorModelo f = desarrolladorService.traerPorId(id);

	    Object body;

	    if (f == null) {
	    	body ="No se puedo traer a la figurita";
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
	    }

	    return ResponseEntity.status(HttpStatus.OK).body(f);
	}


}