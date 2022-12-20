package edu.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.it.dto.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
	
}
