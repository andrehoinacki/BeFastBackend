package com.befast.springboot.befastprojeto.admin.categoria;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	@Query("SELECT c FROM Categoria c ORDER BY c.nome")
	List<Categoria> list();

	@Query("SELECT c FROM Categoria c  WHERE c.nome=:#{#nome} ")
	Categoria getByNome(String nome);
}