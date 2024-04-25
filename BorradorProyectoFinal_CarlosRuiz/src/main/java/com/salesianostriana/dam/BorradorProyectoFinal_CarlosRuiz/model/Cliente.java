package com.salesianostriana.dam.BorradorProyectoFinal_CarlosRuiz.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
public class Cliente {
	
	@Id @GeneratedValue
	private long id;
	
	private String nombre, apellidos, dni;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDate fechaNacimiento;
	
	@EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Builder.Default
    @OneToMany(
    			mappedBy = "cliente",
    			fetch = FetchType.EAGER,
    			cascade = CascadeType.ALL,
    			orphanRemoval = true
    )
	private List<Billete> listaBilletes = new ArrayList<>();
	
	@ManyToOne
	private Tren tren;

	public Cliente(String nombre, String apellidos, String dni, LocalDate fechaNacimiento,
			List<Billete> listaBilletes) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.listaBilletes = listaBilletes;
	}

	
}
