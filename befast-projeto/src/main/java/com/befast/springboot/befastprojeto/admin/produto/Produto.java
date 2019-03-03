package com.befast.springboot.befastprojeto.admin.produto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.befast.springboot.befastprojeto.admin.categoria.Categoria;
import com.befast.springboot.befastprojeto.admin.restricao.Restricao;

@Entity
public class Produto {
	@Id
	@GeneratedValue
	@Column(name="id")	
	private Long id;
	
	@Column(name="codigo")
	private String codigo;
	
	@Column(name="descricao")
	private String descricao;

	@Column(name="valor")
	private Float valor;
	
	@Column(name="quantidade", columnDefinition="int default 0")
	private Integer quantidade;
	
	@ManyToMany(fetch = FetchType.EAGER)	
	@JoinColumn(name = "restricao_id", foreignKey = @ForeignKey(name="FK_PRODUTO_RESTRICAO"), insertable = true, updatable = true)
	private List<Restricao> restricoes;

	@ManyToOne(fetch = FetchType.EAGER)	
	@JoinColumn(name = "categoria_id", foreignKey = @ForeignKey(name="FK_PRODUTO_CATEGORIA"), insertable = true, updatable = true)
	private Categoria categoria;

	public Produto() {
		
	}
	
	public Produto(String codigo, String descricao, Categoria categoria, float valor) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.categoria = categoria;
		this.valor = valor;
	}

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
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the valor
	 */
	public Float getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(Float valor) {
		this.valor = valor;
	}

	/**
	 * @return the restricoes
	 */
	public List<Restricao> getRestricoes() {
		return restricoes;
	}

	/**
	 * @param restricoes the restricoes to set
	 */
	public void setRestricoes(List<Restricao> restricoes) {
		this.restricoes = restricoes;
	}

	/**
	 * @return the categoria
	 */
	public Categoria getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	/**
	 * @return the quantidade
	 */
	public Integer getQuantidade() {
		return quantidade;
	}

	/**
	 * @param quantidade the quantidade to set
	 */
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

}
