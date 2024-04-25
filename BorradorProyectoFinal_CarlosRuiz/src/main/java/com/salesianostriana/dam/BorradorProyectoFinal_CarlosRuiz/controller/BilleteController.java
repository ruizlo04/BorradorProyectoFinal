package com.salesianostriana.dam.BorradorProyectoFinal_CarlosRuiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.BorradorProyectoFinal_CarlosRuiz.service.BilleteService;

@Controller
public class BilleteController {
	
	@Autowired
	private BilleteService billeteService;
	
	@GetMapping ("/trenes/billete")
	public String controlarListaBilletes(Model model) {
		model.addAttribute("billeteList", billeteService.getLista());
		return "index";
	}

}
