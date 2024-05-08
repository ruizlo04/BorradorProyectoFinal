package com.salesianostriana.dam.BorradorProyectoFinal_CarlosRuiz.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.BorradorProyectoFinal_CarlosRuiz.model.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{
	
	Optional<Usuario> findFirstByUsername(String username);


}
