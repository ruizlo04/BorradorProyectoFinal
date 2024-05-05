package com.salesianostriana.dam.BorradorProyectoFinal_CarlosRuiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.BorradorProyectoFinal_CarlosRuiz.model.Trabajador;
import com.salesianostriana.dam.BorradorProyectoFinal_CarlosRuiz.service.TrabajadorService;

@Controller
@RequestMapping("/trabajador")
public class TrabajadorController {
	
	@Autowired
	private TrabajadorService trabajadorService;
	
	@GetMapping ("/registrarTrabajador")
	public String showForm(Model model) {
		
		Trabajador t = new Trabajador(); 		
		model.addAttribute("trabajadorForm", t);
		
		return "formTrabajador";
		
	}
	
	@PostMapping ("/addTrabajador")
	public String submit(@ModelAttribute("trabajadorForm") Trabajador t,  Model model) {
		trabajadorService.save(t);
		model.addAttribute("trabajadorList", trabajadorService.findAll());
		return "redirect:/trabajador/listarTrabajadores";
	}
	
	@GetMapping ("/listarTrabajadores")
	public String listarTrabajadores(@ModelAttribute("trabajadorForm") Trabajador t,  Model model) {
		model.addAttribute("trabajadorList", trabajadorService.findAll());
		return "admin";
	}

}
