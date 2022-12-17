package com.example.proyecto_manager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.proyecto_manager.helpers.ViewRouteHelper;

@Controller
@RequestMapping("/index")
public class ControladorIndex {
	
	@GetMapping("")
	public String inicio() {
		return ViewRouteHelper.INDEX; 
	}
	
	//@GetMapping("/logout")
	//public String logoutPrueba() {
		//return ViewRouteHelper.USER_LOGOUT; 
	//}

	@GetMapping("nombre/{nombre_variable}")
	public ModelAndView cambiarNombre (@PathVariable("nombre_variable")String nombre_variable){
		ModelAndView modelV = new ModelAndView(ViewRouteHelper.INDEX);
		modelV.addObject("nombre_variable", nombre_variable);
		
		return modelV; 
	}
	
	@GetMapping("/nombre") //?nombre_variable=Nico
	public ModelAndView cambiarNombreNuevo(@RequestParam(name="nombre_variable", required=true, defaultValue="null") String nombre ){

		//ModelAndView modelV = new ModelAndView(ViewRouteHelper.INDEX2);
		ModelAndView modelV = new ModelAndView(ViewRouteHelper.INDEX);

		modelV.addObject("variableParaTemplate", nombre);

		return modelV;
	
	
}
}
