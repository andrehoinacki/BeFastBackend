package com.befast.springboot.befastprojeto.relatorio.recebiveis;

import java.util.List;

import com.befast.springboot.befastprojeto.admin.usuario.Usuario;

public class RecebiveisPageResponse  {
    private List<Usuario> list;
	private int totalPages;
	private long totalElements;

	/**
	 * @return the list
	 */
	public List<Usuario> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<Usuario> list) {
		this.list = list;
	}

	/**
	 * @return the totalPages
	 */
	public int getTotalPages() {
		return totalPages;
	}

	/**
	 * @param totalPages the totalPages to set
	 */
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	/**
	 * @return the totalElements
	 */
	public long getTotalElements() {
		return totalElements;
	}

	/**
	 * @param totalElements the totalElements to set
	 */
	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}
}