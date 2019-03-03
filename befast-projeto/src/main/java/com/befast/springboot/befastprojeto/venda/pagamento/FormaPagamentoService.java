package com.befast.springboot.befastprojeto.venda.pagamento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
public class FormaPagamentoService {
	
	@Autowired
	private FormaPagamentoRepository formaPgtoRepository;

	@Cacheable("list-formPgto")
	public List<FormaPagamento> list(){
		return formaPgtoRepository.list();
	}

	public FormaPagamento getByNome(String nome) {
		return formaPgtoRepository.getByNome(nome);
	}
	
}