package com.befast.springboot.befastprojeto.relatorio.vendas;

import java.util.List;

import com.befast.springboot.befastprojeto.venda.Venda;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VendasRepository extends JpaRepository<Venda, Long>{
	@Query(	"SELECT v FROM Venda v															" +
	"WHERE 																					" +
	"			v.dataVenda BETWEEN :#{#filter.dataInicial} AND :#{#filter.dataFinal}		" +
	"	AND 	(	:#{#filter.idCliente} 				IS NULL OR 	lower(v.cliente.id) = :#{#filter.idCliente} )	"
	)
	Page<Venda> list(Pageable pageable, @Param("filter") VendasFilter filter);
}