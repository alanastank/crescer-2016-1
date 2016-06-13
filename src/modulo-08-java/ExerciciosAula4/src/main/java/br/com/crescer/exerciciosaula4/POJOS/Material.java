package br.com.crescer.exerciciosaula4.POJOS;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "MATERIAL")
public class Material implements Serializable {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SQMATERIAL")
    @SequenceGenerator(name = "SQMATERIAL", sequenceName = "SQMATERIAL", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "IDMATERIAL")
    private long id;

    @Basic(optional = false)
    @Column(name = "DESCRICAO", length = 50)
    private String descricao;

    @Basic(optional = false)
    @Column(name = "PESOLIQUIDO", scale = 5, precision = 15)
    private Double pesoLiquido;

    @Basic(optional = false)
    @Column(name = "PRECOCUSTO", scale = 2, precision = 12)
    private Double precoCusto;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPesoLiquido() {
        return pesoLiquido;
    }

    public void setPesoLiquido(Double pesoLiquido) {
        this.pesoLiquido = pesoLiquido;
    }

    public Double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(Double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public Material(String descricao, Double pesoLiquido, Double precoCusto) {
        this.descricao = descricao;
        this.pesoLiquido = pesoLiquido;
        this.precoCusto = precoCusto;
    }

    public Material() {
    }
}
