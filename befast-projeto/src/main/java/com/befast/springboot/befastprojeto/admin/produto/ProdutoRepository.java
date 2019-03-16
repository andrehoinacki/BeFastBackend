package com.befast.springboot.befastprojeto.admin.produto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	@Query(	"SELECT p FROM Produto p																									" +
	"WHERE 																														" +
	"			(	:#{#filter.codigo} 				IS NULL OR 	lower(p.codigo) LIKE %:#{#filter.codigo}%	)	" + 
	"	AND 	(	:#{#filter.descricao} 				IS NULL OR 	lower(p.descricao) LIKE %:#{#filter.descricao}% )	"
	)
	Page<Produto> list(Pageable pageable, @Param("filter") ProdutoFilter filter);

	@Query("SELECT p FROM Produto p  WHERE p.codigo=:#{#produto.codigo} ")
	Produto qryUniqueProduto(Produto produto);

	@Query("SELECT p FROM Produto p  WHERE p.id=:#{#id} ")
	Produto findProdutoById(long id);

	@Query("SELECT p FROM Produto p  WHERE p.codigo=:#{#codigo} ")
	Produto getByCodigo(String codigo);
}