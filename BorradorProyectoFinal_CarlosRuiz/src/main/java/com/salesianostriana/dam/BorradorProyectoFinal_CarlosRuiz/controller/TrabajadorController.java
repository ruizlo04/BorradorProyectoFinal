package com.salesianostriana.dam.BorradorProyectoFinal_CarlosRuiz.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.BorradorProyectoFinal_CarlosRuiz.model.Estacion;
import com.salesianostriana.dam.BorradorProyectoFinal_CarlosRuiz.model.Trabajador;
import com.salesianostriana.dam.BorradorProyectoFinal_CarlosRuiz.service.EstacionService;
import com.salesianostriana.dam.BorradorProyectoFinal_CarlosRuiz.service.TrabajadorService;

@Controller
@RequestMapping("/trabajador")
public class TrabajadorController {
	
	@Autowired
	private TrabajadorService trabajadorService;
	
	@Autowired
	private EstacionService estacionService;
	
	@GetMapping ("/registrarTrabajador")
	public String showForm(Model model) {
		
		Trabajador t = new Trabajador(); 		
		model.addAttribute("trabajadorForm", t);
		
		return "formTrabajador";
		
	}
	
	@PostMapping ("/addTrabajador")
	public String submit(@ModelAttribute("trabajadorForm") Trabajador t,  Model model) {
		Optional<Estacion> estacionOptional = estacionService.findById(t.getEstacion().getId());
	    
	    if (estacionOptional.isPresent()) {
	        Estacion estacion = estacionOptional.get();
	        t.setEstacion(estacion);
	        trabajadorService.save(t);
	    }
		return "redirect:/trabajador/listarTrabajadores";
	}
	
	@GetMapping ("/listarTrabajadores")
	public String listarTrabajadores(@ModelAttribute("trabajadorForm") Trabajador t,  Model model) {
		model.addAttribute("trabajadorList", trabajadorService.findAll());
		return "admin";
	}
	
	@GetMapping("/editar/{id}")
	public String showFormEdit(@PathVariable("id") long id, Model model) {
	    Optional<Trabajador> aEditarOptional = trabajadorService.findById(id);
	    if (aEditarOptional.isPresent()) {
	        Trabajador aEditar = aEditarOptional.get(); 
	        List<Estacion> estacionList = estacionService.findAll();
	        model.addAttribute("trabajadorForm", aEditar);
	        model.addAttribute("estacionList", estacionList);
	        return "formTrabajador";
	    } else {
	        return "redirect:/trabajador/listarTrabajadores";
	    }
	}


	
	@PostMapping("/editar/submit")
	public String procesarFormularioEdit(@ModelAttribute("trabajadorForm") Trabajador t) {
		trabajadorService.edit(t);
		return "redirect:/trabajador/listarTrabajadores";
	}
	
	@GetMapping("/borrar/{id}")
	public String borrar(@PathVariable("id") Long id) {
		trabajadorService.deleteById(id);
		return "redirect:/trabajador/listarTrabajadores";
	}

}
