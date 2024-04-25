package com.salesianostriana.dam.BorradorProyectoFinal_CarlosRuiz.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.BorradorProyectoFinal_CarlosRuiz.model.Tren;

@Service
public class TrenService {
	
	public List<Tren> getLista(){
		return Arrays.asList(
				new Tren("media distancia"), 
				new Tren("larga distancia")
				);
	}

}
