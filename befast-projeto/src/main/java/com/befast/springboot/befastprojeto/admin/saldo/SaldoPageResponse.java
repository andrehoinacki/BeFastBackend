package com.befast.springboot.befastprojeto.admin.saldo;

import java.util.List;

public class SaldoPageResponse  {
    private List<Saldo> list;
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

	public List<Saldo> getList() {
		return list;
	}

	public void setList(List<Saldo> list) {
		this.list = list;
	}
	

}