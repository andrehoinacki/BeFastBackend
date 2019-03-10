package com.befast.springboot.befastprojeto.venda;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import com.befast.springboot.befastprojeto.admin.produto.Produto;

@Entity
public class Venda extends Transacao{
	
	@ManyToMany(fetch = FetchType.EAGER)	
	@JoinColumn(name = "produto_id", foreignKey = @ForeignKey(name="FK_VENDA_PRODUTO"), insertable = true, updatable = true)
	private List<Produto> itens;

	public List<Produto> getItens() {
		return itens;
	}

	public void setItens(List<Produto> itens) {
		this.itens = itens;
	}
	
}
