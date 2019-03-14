package com.befast.springboot.befastprojeto.relatorio.recebiveis;

import com.befast.springboot.befastprojeto.admin.usuario.Usuario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RecebiveisRepository extends JpaRepository<Usuario, Long>{
	@Query(
		"SELECT u FROM Usuario u 												"
	)

	//select u.nome, sum(credito) from befast.usuario u join befast.usuario_saldo us on u.id = us.usuario_id join befast.saldo s on s.id = us.saldo_id where s.status = 'Creditado';
	Page<Usuario> list(Pageable pageable, @Param("filter") RecebiveisFilter filter);
}