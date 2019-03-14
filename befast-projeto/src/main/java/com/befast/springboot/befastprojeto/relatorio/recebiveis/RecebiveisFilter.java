package com.befast.springboot.befastprojeto.relatorio.recebiveis;

public class RecebiveisFilter {
 
    int pageNumber = 1;
	int pageSize = 10;
	String statusSaldo;

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
	 * @return the statusSaldo
	 */
	public String getStatusSaldo() {
		return statusSaldo;
	}

	/**
	 * @param statusSaldo the statusSaldo to set
	 */
	public void setStatusSaldo(String statusSaldo) {
		this.statusSaldo = statusSaldo;
	}


}