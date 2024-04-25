package com.salesianostriana.dam.BorradorProyectoFinal_CarlosRuiz.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Estacion {
	
	@Id @GeneratedValue
	private long id;
	
	private String nombre;	
	
	private List<Tren> listaTrenes;

	public Estacion(String nombre, List<Tren> listaTrenes) {
		super();
		this.nombre = nombre;
		this.listaTrenes = listaTrenes;
	}
	
	

}
