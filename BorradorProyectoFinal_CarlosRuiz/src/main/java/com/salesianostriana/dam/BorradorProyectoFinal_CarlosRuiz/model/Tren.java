package com.salesianostriana.dam.BorradorProyectoFinal_CarlosRuiz.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

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
public class Tren {
	
	@Id @GeneratedValue
	private long id;
	
	@DateTimeFormat(iso =ISO.DATE_TIME)
	private LocalDateTime horario;
	
	private String tipoTren;
	
	private List<Cliente> listaClientes;

}
