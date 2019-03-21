package com.befast.springboot.befastprojeto.admin.saldo;

import java.util.List;

import com.befast.springboot.befastprojeto.admin.saldo.Saldo;
import com.befast.springboot.befastprojeto.admin.saldo.SaldoFilter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SaldoRepository extends JpaRepository<Saldo, Long>{

    @Query(	"SELECT s FROM Usuario u join u.saldo s																								" +
	"WHERE 		1 = 1 																												" +
	//"			s.data BETWEEN :#{#filter.dataInicial} AND :#{#filter.dataFinal}		" + 
	"	AND 	(	:#{#filter.idCliente} 				IS NULL OR 	lower(u.id) = :#{#filter.idCliente} )	"
	)
	Page<Saldo> list(Pageable pageable, @Param("filter") SaldoFilter filter);
}