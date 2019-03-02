package com.befast.springboot.befastprojeto.admin.categoria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Cacheable("list-categoria")
	public List<Categoria> list(){
		return categoriaRepository.list();
	}

	public Categoria getByNome(String nome) {
		return categoriaRepository.getByNome(nome);
	}
	
}