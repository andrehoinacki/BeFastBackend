package com.befast.springboot.befastprojeto.admin.produto;

import java.util.List;

public class ProdutoPageResponse  {
    private List<Produto> list;
	private int totalPages;
	private long totalElements;

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}

	public List<Produto> getList() {
		return list;
	}

	public void setList(List<Produto> list) {
		this.list = list;
	}
	

}