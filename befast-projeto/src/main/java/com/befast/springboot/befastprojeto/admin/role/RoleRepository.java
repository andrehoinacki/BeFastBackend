package com.befast.springboot.befastprojeto.admin.role;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

	@Query("SELECT r FROM Role r ORDER BY r.nome")
	List<Role> list();

	@Query("SELECT r FROM Role r  WHERE r.nome=:#{#nome} ")
	Role getByNome(String nome);
}