package com.befast.springboot.befastprojeto.admin.restricao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
public class RestricaoService {
	
	@Autowired
	private RestricaoRepository restricaoRepository;

	@Cacheable("list-restricao")
	public List<Restricao> list(){
		return restricaoRepository.list();
	}

	public Restricao getByNome(String nome) {
		return restricaoRepository.getByNome(nome);
	}
	
}