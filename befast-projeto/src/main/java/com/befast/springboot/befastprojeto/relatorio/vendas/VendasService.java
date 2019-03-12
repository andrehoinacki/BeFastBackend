package com.befast.springboot.befastprojeto.relatorio.vendas;

import com.befast.springboot.befastprojeto.venda.Venda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class VendasService {

	@Autowired
	private VendasRepository vendasRepository;

	public VendasPageResponse list(VendasFilter filter) {
		PageRequest pageRequest = PageRequest.of(filter.getPageNumber() - 1, filter.getPageSize(),
				new Sort(Sort.Direction.ASC, "dataVenda"));
		Page<Venda> page = vendasRepository.list(pageRequest, filter);

		VendasPageResponse pageResponse = new VendasPageResponse();
		pageResponse.setList(page.getContent());
		pageResponse.setTotalElements(page.getTotalElements());
		pageResponse.setTotalPages(page.getTotalPages());

		return pageResponse;
	}
}