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
@Table(name = "CIDADE")
public class Cidade implements Serializable {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SQCIDADE")
    @SequenceGenerator(name = "SQCIDADE", sequenceName = "SQCIDADE", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "IDCIDADE")
    public long id;

    @Basic(optional = false)
    @Column(name = "NOME", length = 30)
    public String nome;

    @Basic(optional = false)
    @Column(name = "UF", length = 2)
    public String uf;

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

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Cidade(String nome, String uf) {
        this.nome = nome;
        this.uf = uf;
    }

    public Cidade() {

    }

}
