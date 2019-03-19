package com.befast.springboot.befastprojeto.venda;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Venda extends Transacao {
	
	@ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)	
	@JoinColumn(name = "item_id", foreignKey = @ForeignKey(name="FK_VENDA_ITEM"), insertable = true, updatable = true)
	private List<ItemVenda> itens;

	@Column(name="total")
	private Float total;

	public List<ItemVenda> getItens() {
		return itens;
	}

	public void setItens(List<ItemVenda> itens) {
		this.itens = itens;
	}

	/**
	 * @return the total
	 */
	public Float getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(Float total) {
		this.total = total;
	}

	
}
