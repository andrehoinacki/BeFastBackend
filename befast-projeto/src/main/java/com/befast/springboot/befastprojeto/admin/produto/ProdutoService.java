package com.befast.springboot.befastprojeto.admin.produto;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public ProdutoPageResponse list(ProdutoFilter filter) {
		PageRequest pageRequest = PageRequest.of(filter.getPageNumber() - 1, filter.getPageSize(),
				new Sort(Sort.Direction.ASC, "descricao"));
		Page<Produto> page = produtoRepository.list(pageRequest, filter);

		ProdutoPageResponse pageResponse = new ProdutoPageResponse();
		pageResponse.setList(page.getContent());
		pageResponse.setTotalElements(page.getTotalElements());
		pageResponse.setTotalPages(page.getTotalPages());

		return pageResponse;
	}

	@Transactional
	public Produto save(Produto produto) throws Exception {
		/**
		 * Valida campos obrigatórios
		 */
		if (produto.getCodigo() == null || produto.getDescricao() == null || produto.getCategoria() == null
				|| produto.getValor() == null || produto.getQuantidade() == null || produto.getQuantidade() <= 0) {
			throw new Exception("ERROR_CAMPOS_OBRIGATORIOS");
		}

		/**
		 * Verifica se já não existe produto com mesmo codigo
		 */
		if (null == produto.getId()) {
			Produto unique = this.verifyUnique(produto);
			if (unique != null && !unique.getId().equals(produto.getId())) {
				throw new Exception("ERROR_REGISTRO_DUPLICADO");
			}
		}

		return produtoRepository.save(produto);
	}

	public Produto verifyUnique(Produto produto) {
		return produtoRepository.qryUniqueProduto(produto);
	}

	public Produto findById(long id) {
		return produtoRepository.findProdutoById(id);
	}

	public void deleteById(long id) {
		produtoRepository.deleteById(id);
	}

}