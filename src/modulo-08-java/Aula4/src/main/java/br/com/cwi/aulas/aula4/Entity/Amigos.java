package br.com.cwi.aulas.aula4.Entity;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name = "AMIGOS")
public class Amigos {

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_AMIGO")
    @SequenceGenerator(name = "SEQ_AMIGO", sequenceName = "SEQ_AMIGO")
    @Basic(optional = false)
    @Column(name = "ID_AMIGO")
    private long id;

    @Basic(optional = false)
    @Column(name = "DATA_ADICAO")
    @Temporal(TemporalType.DATE)
    private Date dataAdicao;

    public long getId() {
        return id;
    }

    public Date getDataAdicao() {
        return dataAdicao;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
