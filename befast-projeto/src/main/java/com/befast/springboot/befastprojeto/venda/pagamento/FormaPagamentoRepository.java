package com.befast.springboot.befastprojeto.venda.pagamento;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long>{

	@Query("SELECT fp FROM FormaPagamento fp ORDER BY fp.nome")
	List<FormaPagamento> list();

	@Query("SELECT fp FROM FormaPagamento fp WHERE fp.nome=:#{#nome} ")
	FormaPagamento getByNome(String nome);
}