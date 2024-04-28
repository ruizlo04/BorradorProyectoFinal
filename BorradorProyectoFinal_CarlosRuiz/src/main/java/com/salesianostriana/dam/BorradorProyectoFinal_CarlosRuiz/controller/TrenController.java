package com.salesianostriana.dam.BorradorProyectoFinal_CarlosRuiz.controller;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.BorradorProyectoFinal_CarlosRuiz.service.TrenService;

@Controller
public class TrenController {
	
	@Autowired
	private TrenService trenService;
	
	@GetMapping ("/trenes")
	public String controlarListaTrenes(Model model) {
		model.addAttribute("trenList", trenService.getLista());
		return "index";
	}

}
