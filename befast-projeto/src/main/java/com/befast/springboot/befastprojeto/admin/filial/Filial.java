package com.befast.springboot.befastprojeto.admin.filial;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.befast.springboot.befastprojeto.admin.saldo.Saldo;

@Entity
public class Filial {
	@Id
	@GeneratedValue
	@Column(name="id")	
	private Long id;
	
	@Column(name="razao_social")
	private String razaoSocial;
	
	@Column(name="nome_fantasia")
	private String nomeFantasia;

	@Column(name="cnpj")
	private String cnpj;
	
	@Column(name="inscricao_estadual")
	private String inscricaoEstadual;
	
	@OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)	
	@JoinColumn(name = "endereco_id", foreignKey = @ForeignKey(name="FK_USUARIO_ENDERECO"), insertable = true, updatable = true)
	private Endereco endereco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}
	
	
}
