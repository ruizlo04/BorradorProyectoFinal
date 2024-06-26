package com.salesianostriana.dam.BorradorProyectoFinal_CarlosRuiz.model;

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
public class Asiento {
	
	@Id @GeneratedValue
	private long codAsiento;
	
	private double precio;

}
