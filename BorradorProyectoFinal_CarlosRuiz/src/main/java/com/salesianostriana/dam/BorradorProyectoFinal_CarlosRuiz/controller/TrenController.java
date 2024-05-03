package com.salesianostriana.dam.BorradorProyectoFinal_CarlosRuiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.BorradorProyectoFinal_CarlosRuiz.model.Tren;
import com.salesianostriana.dam.BorradorProyectoFinal_CarlosRuiz.service.EstacionService;
import com.salesianostriana.dam.BorradorProyectoFinal_CarlosRuiz.service.TrenService;

@Controller
public class TrenController {
	
	@Autowired
	private TrenService trenService;
	
	@Autowired
	private EstacionService estacionService;
	
	@GetMapping ("/trenes")
	public String controlarListaTrenes(@ModelAttribute("trenForm") Tren t,  Model model) {
		model.addAttribute("trenList", trenService.findAll());
		return "listaTren";
	}

	@GetMapping ("/index")
	public String controlarAdmin(Model model) {
		model.addAttribute("trenList", trenService.findAll());
		return "index";
	}
	
	@GetMapping("/tren")
	public String showForm(Model model) {
	    Tren t = new Tren();
	    model.addAttribute("estacionList", estacionService.findAll());
	    model.addAttribute("trenForm", t);
	    return "formTren";
	}
	
	@PostMapping("/addTren")
	public String submitTren(@ModelAttribute("trenForm") Tren t, Model model) {
		trenService.save(t);
		model.addAttribute("trenList", trenService.findAll());
		return "listaTren";
	}
}
