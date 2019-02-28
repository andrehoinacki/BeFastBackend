package com.befast.springboot.befastprojeto.admin.usuario;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	List<Usuario> findByUsername(String username);

	@Query(	"SELECT u FROM Usuario u																									" +
	"WHERE 																														" +
	"			(	:#{#filter.nome} 				IS NULL OR 	lower(u.nome) LIKE %:#{#filter.nome}%	)	" + 
	"	AND 	(	:#{#filter.username} 				IS NULL OR 	lower(u.username) LIKE %:#{#filter.username}% )	"
	)
	Page<Usuario> list(Pageable pageable, @Param("filter") UsuarioFilter filter);

	@Query("SELECT u FROM Usuario u  WHERE u.username=:#{#usuario.username} ")
	Usuario qryUniqueUsuario(Usuario usuario);

	@Query("SELECT u FROM Usuario u  WHERE u.id=:#{#id} ")
	Usuario findUsuarioById(long id);
}