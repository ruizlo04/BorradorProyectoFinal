package com.salesianostriana.dam.BorradorProyectoFinal_CarlosRuiz.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.BorradorProyectoFinal_CarlosRuiz.model.Estacion;
import com.salesianostriana.dam.BorradorProyectoFinal_CarlosRuiz.model.Tren;
import com.salesianostriana.dam.BorradorProyectoFinal_CarlosRuiz.service.EstacionService;
import com.salesianostriana.dam.BorradorProyectoFinal_CarlosRuiz.service.TrenService;

@Controller
@RequestMapping("/trenes")
public class TrenController {
	
	@Autowired
	private TrenService trenService;
	
	@Autowired
	private EstacionService estacionService;
	
	@GetMapping ("/listarTrenes")
	public String controlarListaTrenes(@ModelAttribute("trenForm") Tren t,  Model model) {
		model.addAttribute("trenList", trenService.findAll());
		return "listaTren";
	}

	@GetMapping ("/mostrarIndice")
	public String controlarAdmin(Model model) {
		model.addAttribute("trenList", trenService.findAll());
		return "index";
	}
	
	@GetMapping("/formularioTren")
	public String showForm(Model model) {
	    Tren t = new Tren();
	    model.addAttribute("trenList", trenService.findAll());
	    model.addAttribute("estacionList", estacionService.findAll());
	    model.addAttribute("trenForm", t);
	    return "formTren";
	}
	
	@PostMapping("/addTren")
	public String submitTren(@ModelAttribute("trenForm") Tren t, Model model) {
		Optional<Estacion> estacionOptional = estacionService.findById(t.getEstacion().getId());
	    
	    if (estacionOptional.isPresent()) {
	        Estacion estacion = estacionOptional.get();
	        t.setEstacion(estacion);
	        trenService.save(t);
	    }
		return "redirect:/trenes/listarTrenes";
	}
}
