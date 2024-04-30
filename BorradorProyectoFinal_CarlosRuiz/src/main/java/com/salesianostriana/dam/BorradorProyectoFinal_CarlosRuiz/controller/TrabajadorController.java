package com.salesianostriana.dam.BorradorProyectoFinal_CarlosRuiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.BorradorProyectoFinal_CarlosRuiz.model.Trabajador;
import com.salesianostriana.dam.BorradorProyectoFinal_CarlosRuiz.service.TrabajadorService;

@Controller
public class TrabajadorController {
	
	@Autowired
	private TrabajadorService trabajadorService;
	
	@GetMapping ("/trabajador")
	public String showForm(Model model) {
		
		Trabajador t = new Trabajador(); 		
		model.addAttribute("trabajadorForm", t);
		
		return "form";
		
	}
	
	@PostMapping ("/addTrabajador")
	public String submit(@ModelAttribute("trabajadorForm") Trabajador t,  Model model) {
		model.addAttribute("trabajador", t);
		return "form";
	}
	
	@GetMapping("/list")
	public String lista(Model model) {
		model.addAttribute("trabajadores", trabajadorService.findAll());
		return "listaTrabajador";
	}

}
