package com.befast.springboot.befastprojeto.relatorio.vendas;

import java.util.Date;

public class VendasFilter {
 
	private Date dataInicial;
	private Date dataFinal;
    int pageNumber = 1;
	int pageSize = 10;

	/**
     * @return the pageNumber
     */
    public int getPageNumber() {
        return pageNumber;
    }

    /**
     * @return the pageSize
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * @param pageNumber the pageNumber to set
     */
    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    /**
     * @param pageSize the pageSize to set
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

	/**
	 * @return the dataInicial
	 */
	public Date getDataInicial() {
		return dataInicial;
	}

	/**
	 * @param dataInicial the dataInicial to set
	 */
	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	/**
	 * @return the dataFinal
	 */
	public Date getDataFinal() {
		return dataFinal;
	}

	/**
	 * @param dataFinal the dataFinal to set
	 */
	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

}