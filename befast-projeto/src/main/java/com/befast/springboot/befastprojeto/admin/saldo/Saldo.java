package com.befast.springboot.befastprojeto.admin.saldo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Saldo {
    @Id
	@GeneratedValue
	@Column(name = "id")
    private Long id;

    @Column(name = "credito")
    private Float credito;

    @Column(name = "status")
    private String status;
    
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the credito
     */
    public Float getCredito() {
        return credito;
    }

    /**
     * @param credito the credito to set
     */
    public void setCredito(Float credito) {
        this.credito = credito;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

}