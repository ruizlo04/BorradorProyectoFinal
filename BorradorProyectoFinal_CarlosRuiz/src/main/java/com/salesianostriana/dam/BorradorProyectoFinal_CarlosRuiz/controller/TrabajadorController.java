package com.salesianostriana.dam.BorradorProyectoFinal_CarlosRuiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.BorradorProyectoFinal_CarlosRuiz.model.Trabajador;

@Controller
public class TrabajadorController {
	
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

}
