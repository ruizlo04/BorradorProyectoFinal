package com.salesianostriana.dam.BorradorProyectoFinal_CarlosRuiz.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tren {
	
	@Id @GeneratedValue
	private long id;
	
	@DateTimeFormat(iso =ISO.DATE_TIME)
	private LocalDateTime horario;
	
	private String tipoTren;
	
	@EqualsAndHashCode.Exclude
    @ToString.Exclude
	private List<Cliente> listaClientes = new ArrayList<>();

	public Tren(LocalDateTime horario, String tipoTren, List<Cliente> listaClientes) {
		super();
		this.horario = horario;
		this.tipoTren = tipoTren;
		this.listaClientes = listaClientes;
	}

	
}
