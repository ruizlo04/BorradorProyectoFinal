package com.salesianostriana.dam.BorradorProyectoFinal_CarlosRuiz.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Billete {
	
	@Id @GeneratedValue
	private long id;
	
	private double precio;
	
	private boolean extra;
	
	private int numClientes;
	
	@ManyToOne
	private Cliente cliente;

	public Billete(double precio, boolean extra, int numClientes) {
		super();
		this.precio = precio;
		this.extra = extra;
		this.numClientes = numClientes;
	}
	
	

}
