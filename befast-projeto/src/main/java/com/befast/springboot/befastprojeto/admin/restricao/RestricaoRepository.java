package com.befast.springboot.befastprojeto.admin.restricao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RestricaoRepository extends JpaRepository<Restricao, Long>{

	@Query("SELECT r FROM Restricao r ORDER BY r.nome")
	List<Restricao> list();

	@Query("SELECT r FROM Restricao r  WHERE r.nome=:#{#nome} ")
	Restricao getByNome(String nome);
}