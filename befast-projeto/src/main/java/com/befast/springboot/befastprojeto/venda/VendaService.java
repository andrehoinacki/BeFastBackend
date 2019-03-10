package com.befast.springboot.befastprojeto.venda;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class VendaService {
	
	@Autowired
	private VendaRepository vendaRepository;

	@Cacheable("list-venda")
	public List<Venda> list(){
		return vendaRepository.list();
	}
	
	@Transactional
	public Venda save(Venda venda) throws Exception {
		/**
		 * Valida campos obrigatórios
		 */
		if (venda.getCliente() == null || venda.getFuncionario() == null ) {
			throw new Exception("ERROR_CAMPOS_OBRIGATORIOS");
		}
				
		return vendaRepository.save(venda);
	}

}
