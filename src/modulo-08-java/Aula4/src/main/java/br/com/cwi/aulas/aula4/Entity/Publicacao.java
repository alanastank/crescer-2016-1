package br.com.cwi.aulas.aula4.Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Publicacao implements Serializable {

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO_FK")
    private Usuario usuario;

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_PUBLICACAO")
    @SequenceGenerator(name = "SEQ_PUBLICACAO", sequenceName = "SEQ_PUBLICACAO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_PUBLICACAO")
    public long idPublicacao;

    @Basic(optional = false)
    @Temporal(TemporalType.TIME)
    @Column(name = "DATA_PUBLICACAO")
    public Date dataPublicacao;

    @Basic(optional = false)
    @Column(name = "CONTEUDO_PUBLICACAO")
    public String conteudo;

    public long getIdPublicacao() {
        return idPublicacao;
    }

    public void setIdPublicacao(long idPublicacao) {
        this.idPublicacao = idPublicacao;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
