package br.com.crescer.exerciciosaula4.POJOS;

import java.io.Serializable;
import javafx.scene.chart.PieChart.Data;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PRODUTO")
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUTO_SEQUENCE")
    @SequenceGenerator(name = "PRODUTO_SEQUENCE", sequenceName = "PRODUTO_SEQUENCE")
    @Basic(optional = false)
    @Column(name = "IDPRODUTO")
    private Long id;

    @Basic(optional = false)
    @Column(name = "NOME", length = 50)
    private String nome;

    @Basic(optional = false)
    @Column(name = "DATACADASTRO")
    @Temporal(TemporalType.DATE)
    private Data dataCadastro;

    @Basic(optional = false)
    @Column(name = "PRECOCUSTO")
    private Double precoCusto;

    @Basic(optional = false)
    @Column(name = "PRECOVENDA")
    private Double precoVenda;

    @Basic(optional = false)
    @Column(name = "SITUACAO", length = 1, columnDefinition = "VARCHAR2(1) DEFAULT 'A'")
    private String situacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Data getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Data dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(Double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public Double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Produto(String nome, Data dataCadastro, Double precoCusto, Double precoVenda, String situacao) {
        this.nome = nome;
        this.dataCadastro = dataCadastro;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.situacao = situacao;
    }

    public Produto() {

    }

}
