package br.com.crescer.exerciciosaula4.POJOS;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SQPEDIDO")
    @SequenceGenerator(name = "SQPEDIDO", sequenceName = "SQPEDIDO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "IDPEDIDO")
    private long id;

    @ManyToOne(targetEntity = Cliente.class, fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "IDCLIENTE")
    private Cliente cliente;

    @Basic(optional = false)
    @Column(name = "DATAPEDIDO")
    @Temporal(TemporalType.DATE)
    private Date dataPedido;

    @Basic(optional = true)
    @Column(name = "DATAENTREGA")
    @Temporal(TemporalType.DATE)
    private Date dataEntrega;

    @Basic(optional = false)
    @Column(name = "VALORPEDIDO", scale = 2, precision = 12)
    private Double valorPedido;

    @Basic(optional = false)
    @Column(name = "SITUACAO", length = 1, columnDefinition = "VARCHAR2(1) DEFAULT 'A'")
    private String situacao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public Double getValorPedido() {
        return valorPedido;
    }

    public void setValorPedido(Double valorPedido) {
        this.valorPedido = valorPedido;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Pedido(Cliente cliente, Date dataPedido, Date dataEntrega, Double valorPedido, String situacao) {
        this.cliente = cliente;
        this.dataPedido = dataPedido;
        this.valorPedido = valorPedido;
        this.situacao = situacao;
    }

    public Pedido() {

    }
}
