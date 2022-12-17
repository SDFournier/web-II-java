package com.example.proyecto_manager.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.core.userdetails.User;

import com.example.proyecto_manager.converters.PaisConverter;
import com.example.proyecto_manager.entities.Desarrollador;
import com.example.proyecto_manager.entities.Pais;
//import com.example.proyecto_manager.entities.User;
import com.example.proyecto_manager.helpers.ViewRouteHelper;
import com.example.proyecto_manager.models.PaisModelo;
import com.example.proyecto_manager.models.TaskModelo;
import com.example.proyecto_manager.services.IAvatarService;
import com.example.proyecto_manager.services.IPaisService;
import com.example.proyecto_manager.services.ITaskService;

import java.util.List;
import java.util.Set;




@Controller
@RequestMapping("tasks")
public class ControladorTask {
	
	@Autowired
	@Qualifier("taskService")
	private ITaskService taskService;
	
	@Autowired
	@Qualifier("avatarService")
	private IAvatarService avatarService;
	
	@Autowired
	@Qualifier("paisConverter")
	private PaisConverter paisConverter;
	
	@Autowired
	@Qualifier("paisService")
	private IPaisService paisService;
	
//esto no va
	//@GetMapping("")
	//public String inicio() {
		//return ViewRouteHelper.INDEX; 
//	}

	//@PreAuthorize("hasRole('ROLE_1')")
	@GetMapping("/createTask")
	public ModelAndView   createTask(Model model) {

		model.addAttribute("task", new TaskModelo());
		
		//User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.TASK_FORM);
		//modelAndView.addObject("usuario", user.getUsername());
		
		return modelAndView;

	}
	
	//nuevas funcionaldiades

	@GetMapping("/editarTask/{id}")
	public ModelAndView  editarTask(@PathVariable("id")int id, Model model) {	



		TaskModelo task = taskService.traerPorId(id);

		model.addAttribute("task", task);


		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.TASK_FORM);


		return modelAndView;	
	}



	@GetMapping("/eliminarTask/{id}")
	public ModelAndView  eliminarTask(@PathVariable("id")int id, Model model) {	


		taskService.remove(id);


		return listaTasks();	
	}
	
	
	


	@GetMapping("/listaTasks")
	public ModelAndView  listaTasks() {	

		ModelAndView mV = new ModelAndView();
		mV.setViewName(ViewRouteHelper.TASK_LIST);
		mV.addObject("listaDeTasks",taskService.getAllModel());

		return mV;	
	}

//terminan las nuevas func

	
	
	
	@PostMapping("/newTask")
	public ModelAndView newTask(@Valid @ModelAttribute("task")TaskModelo task, 
			BindingResult b, @RequestParam("file") MultipartFile imagen
			) {
		
		ModelAndView mV = new ModelAndView();
		
		if(b.hasErrors()) {
			mV.setViewName(ViewRouteHelper.TASK_FORM);

		}else {
			if(!imagen.isEmpty()) {

				Path directorioImagenes = Paths.get("src//main//resources//static/images");

				String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();

				try {
					byte[] bytesImg = imagen.getBytes();
					Path rutaCompleta = Paths.get(rutaAbsoluta + "//"+imagen.getOriginalFilename());
					Files.write(rutaCompleta, bytesImg);

					task.getAvatar().setImagen(imagen.getOriginalFilename());

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}





			//Modificamos el insertar de la task para que se inserte el avatar tambien...
			taskService.insertOrUpdate(task); 

			mV.setViewName(ViewRouteHelper.TASK_NEW);
			mV.addObject("task", task);
			
			//Podríamos tambien agregarle las tasks que tenemos en la BD
			mV.addObject("listaDeTasks",taskService.getAllModel());

		}

		
		
		return mV;
	}
	
	
	
	//mapping de paises
	
	
	@GetMapping("/agregarFavorito/{id}")
	public ModelAndView  agregarFavorito(@PathVariable("id")int id, Model model) {	



		TaskModelo task = taskService.traerPorId(id);

		List<Pais> paises = paisService.getAll();

		model.addAttribute("task", task);
		model.addAttribute("paises",paises);
		
		//como "Seria"
		//mV.addObject("listaDeTasks",taskService.getAllModel());
		
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.TASK_FAVORITO);


		return modelAndView;	
	}



	@GetMapping("/detalles/{id}")
	public ModelAndView  detalles(@PathVariable("id")int id, Model model) {	



		TaskModelo task = taskService.traerPorId(id);

		Set<Pais> paises = taskService.paisesDeLaTask(id);

		Set<Desarrollador> figuritas = taskService.DesarrolladoresDeLaTask(id);

		model.addAttribute("task", task);
		model.addAttribute("paises",paises);
		model.addAttribute("figuritas",figuritas);


		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.TASK_DETALLES);


		return modelAndView;	
	}


	@GetMapping("/agregar/{id}/{idEquipo}")
	public ModelAndView  agregar(@PathVariable("id")int id,@PathVariable("idEquipo")int idEquipo, Model model) {	

		

		TaskModelo task = taskService.traerPorId(id);
		
		
		
	///lo nuevo de Many to many reparado 
		//Agrego a la lista los paises que ya tenia, esto se puede hacer (MEJOR Aún
				//en service task, crear un metodo que me retorne a la taskModelo pero con sus paises
				//Traigo sus relaciones
				Set<Pais> paises = taskService.paisesDeLaTask(id);

				if(paises != null) {
					for (Pais p : paises) {

						task.getPaises().add(paisService.traerPorId(p.getId()));

					}
				}
	//termina lo nuevo

		PaisModelo pais = paisService.traerPorId(idEquipo);

		task.getPaises().add(pais);


		taskService.insertOrUpdateSet(task);


		ModelAndView mV = new ModelAndView();

		mV.setViewName(ViewRouteHelper.TASK_LIST);
		mV.addObject("listaDeTasks",taskService.getAll());


		return mV;	
	}


}
