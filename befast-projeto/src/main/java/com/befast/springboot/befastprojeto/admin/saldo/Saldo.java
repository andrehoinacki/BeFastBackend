package com.befast.springboot.befastprojeto.admin.saldo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

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
    
    @Column(name = "data", columnDefinition = "DATETIME NULL DEFAULT CURRENT_TIMESTAMP")
    private Date data;

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

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

}