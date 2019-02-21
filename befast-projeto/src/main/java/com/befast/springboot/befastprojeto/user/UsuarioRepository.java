package com.befast.springboot.befastprojeto.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	List<Usuario> findByUsername(String username);
}