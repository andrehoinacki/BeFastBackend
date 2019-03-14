package com.befast.springboot.befastprojeto.relatorio.recebiveis;

import com.befast.springboot.befastprojeto.admin.usuario.Usuario;
import com.befast.springboot.befastprojeto.venda.Venda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class RecebiveisService {

	@Autowired
	private RecebiveisRepository recebiveisRepository;

	public RecebiveisPageResponse list(RecebiveisFilter filter) {
		PageRequest pageRequest = PageRequest.of(filter.getPageNumber() - 1, filter.getPageSize(),
				new Sort(Sort.Direction.ASC, "nome"));
		Page<Usuario> page = recebiveisRepository.list(pageRequest, filter);

		RecebiveisPageResponse pageResponse = new RecebiveisPageResponse();
		pageResponse.setList(page.getContent());
		pageResponse.setTotalElements(page.getTotalElements());
		pageResponse.setTotalPages(page.getTotalPages());

		return pageResponse;
	}
}