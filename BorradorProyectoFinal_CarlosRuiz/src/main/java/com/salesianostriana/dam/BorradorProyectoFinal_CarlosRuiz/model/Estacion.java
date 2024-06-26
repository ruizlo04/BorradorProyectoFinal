package com.salesianostriana.dam.BorradorProyectoFinal_CarlosRuiz.model;

import java.util.ArrayList; 
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Estacion {
	
	@Id @GeneratedValue
	private long id;
	
	private String nombre;	
	
	@EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Builder.Default
    @OneToMany(
    			mappedBy = "estacion",
    			fetch = FetchType.EAGER
    )
	private List<Tren> listaTrenes = new ArrayList<>();
	
	@OneToMany(
			mappedBy = "estacion",
			fetch = FetchType.EAGER, 
			cascade = CascadeType.ALL,
			orphanRemoval = true
    )
	private List<Trabajador> listaTrabajador = new ArrayList<>();

	
	public Estacion(long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}


	public Estacion(String nombre, List<Tren> listaTrenes, List<Trabajador> listaTrabajador) {
		super();
		this.nombre = nombre;
		this.listaTrenes = listaTrenes;
		this.listaTrabajador = listaTrabajador;
	}
	
	

}
