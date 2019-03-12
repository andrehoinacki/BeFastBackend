package com.befast.springboot.befastprojeto.venda;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.befast.springboot.befastprojeto.admin.usuario.Usuario;
import com.befast.springboot.befastprojeto.venda.pagamento.FormaPagamento;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
abstract public class Transacao {
	
	@Id
	@GeneratedValue
	@Column(name="id")	
	private Long id;
	
	@Column(name="data_venda")
	Date dataVenda;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})	
	@JoinColumn(name = "funcionario_id", foreignKey = @ForeignKey(name="FK_TRANSACAO_USUARIO"), insertable = true, updatable = true)		
	Usuario funcionario;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})	
	@JoinColumn(name = "cliente_id", foreignKey = @ForeignKey(name="FK_TRANSACAO_USUARIO"), insertable = true, updatable = true)
	Usuario cliente;
	
	@OneToOne(fetch = FetchType.EAGER)	
	@JoinColumn(name = "forma_pagamento_id", foreignKey = @ForeignKey(name="FK_TRANSACAO_FORMA_PAGAMENTO"), insertable = true, updatable = true)
	FormaPagamento pagamento;
	
		
	public Date getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}
	public Usuario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Usuario funcionario) {
		this.funcionario = funcionario;
	}
	public Usuario getCliente() {
		return cliente;
	}
	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}
	public FormaPagamento getPagamento() {
		return pagamento;
	}
	public void setPagamento(FormaPagamento pagamento) {
		this.pagamento = pagamento;
	}
		
}
