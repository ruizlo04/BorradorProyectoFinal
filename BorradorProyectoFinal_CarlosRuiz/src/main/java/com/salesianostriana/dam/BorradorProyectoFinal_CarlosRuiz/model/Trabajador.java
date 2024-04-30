package com.salesianostriana.dam.BorradorProyectoFinal_CarlosRuiz.model;

import jakarta.persistence.Column;
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
public class Trabajador {
	
	@Id @GeneratedValue @Column(name = "codTrabajador")
	private long codTrabajador;
	
	private String nombre, apellidos, dni;
	
	private double sueldo;

}
