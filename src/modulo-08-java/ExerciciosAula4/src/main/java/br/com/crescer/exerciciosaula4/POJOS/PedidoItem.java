package br.com.crescer.exerciciosaula4.POJOS;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PEDIDOITEM")
public class PedidoItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQPEDIDOITEM")
    @SequenceGenerator(name = "SQPEDIDOITEM", sequenceName = "SQPEDIDOITEM")
    @Basic(optional = false)
    @Column(name = "IDPEDIDOITEM")
    private Long id;

    @OneToOne(targetEntity = Pedido.class, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "IDPEDIDO")
    private Pedido pedido;

    @OneToOne(targetEntity = Produto.class, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "IDPRODUTO")
    private Produto produto;

    @Basic(optional = false)
    @Column(name = "QUANTIDADE")
    private int quantidade;

    @Basic(optional = false)
    @Column(name = "PRECOUNITARIO")
    private Double precoUnitario;

    @Basic(optional = false)
    @Column(name = "SITUACAO")
    private String situacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public PedidoItem(Pedido pedido, Produto produto, int quantidade, Double precoUnitario, String situacao) {
        this.pedido = pedido;
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.situacao = situacao;
    }

    public PedidoItem() {

    }

}
