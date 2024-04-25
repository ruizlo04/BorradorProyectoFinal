package com.salesianostriana.dam.BorradorProyectoFinal_CarlosRuiz.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.BorradorProyectoFinal_CarlosRuiz.model.Billete;

@Service
public class BilleteService {
	
	public List<Billete> getLista(){
		return Arrays.asList(
				new Billete(60.00, false, 3), 
				new Billete(127.8, true, 2)
				);
	}

}
