package com.befast.springboot.befastprojeto.venda;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.befast.springboot.befastprojeto.admin.produto.Produto;

@Entity
public class ItemVenda {
	
    @Id
	@GeneratedValue
	@Column(name="id")	
    private Long id;
    
    @ManyToOne(fetch = FetchType.EAGER)	
    @JoinColumn(name = "produto_id", foreignKey = @ForeignKey(name="FK_PRODUTO_CATEGORIA"), insertable = true, updatable = true)
    private Produto produto;
    
    @Column(name="quantidade")	
    private Integer quantidade;

    @Column(name="valorProduto")
    private Float valorItem;

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
     * @return the produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
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

    /**
     * @return the valorItem
     */
    public Float getValorItem() {
        return valorItem;
    }

    /**
     * @param valorItem the valorItem to set
     */
    public void setValorItem(Float valorItem) {
        this.valorItem = valorItem;
    }

}
