package br.com.crescer.exerciciosaula4.POJOS;

import java.io.Serializable;
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
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTE")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SQCLIENTE")
    @SequenceGenerator(name = "SQCLIENTE", sequenceName = "SQCLIENTE", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "IDCLIENTE")
    private long id;

    @Basic(optional = false)
    @Column(name = "NOME", length = 50)
    private String nome;

    @Basic(optional = false)
    @Column(name = "RAZAOSOCIAL", length = 50)
    private String razaoSocial;

    @Basic(optional = false)
    @Column(name = "ENDERECO", length = 35)
    private String endereco;

    @Basic(optional = false)
    @Column(name = "BAIRRO", length = 30)
    private String bairro;

    @ManyToOne(targetEntity = Cidade.class, fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "IDCIDADE")
    private Cidade cidade;

    @Basic(optional = false)
    @Column(name = "CEP", precision = 8, scale = 0)
    private Integer cep;

    @Basic(optional = false)
    @Column(name = "SITUACAO")
    private String situacao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Cliente(String nome, String razaoSocial, String endereco, String bairro, Cidade cidade, Integer cep, String situacao) {
        this.nome = nome;
        this.razaoSocial = razaoSocial;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.situacao = situacao;
    }

    public Cliente() {

    }
}
