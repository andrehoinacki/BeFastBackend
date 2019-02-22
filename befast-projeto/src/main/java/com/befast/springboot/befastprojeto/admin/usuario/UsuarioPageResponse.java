package com.befast.springboot.befastprojeto.admin.usuario;

import java.util.List;

public class UsuarioPageResponse  {
    private List<Usuario> list;
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

	public List<Usuario> getList() {
		return list;
	}

	public void setList(List<Usuario> list) {
		this.list = list;
	}
	

}