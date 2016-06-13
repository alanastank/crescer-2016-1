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
@Table(name = "PRODUTOMATERIAL")
public class ProdutoMaterial implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQPRODUTOMATERIAL")
    @SequenceGenerator(name = "SQPRODUTOMATERIAL", sequenceName = "SQPRODUTOMATERIAL")
    @Basic(optional = false)
    @Column(name = "IDPRODUTOMATERIAL")
    private Long id;

    @OneToOne(targetEntity = Produto.class, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "IDPRODUTO")
    private Produto produto;

    @OneToOne(targetEntity = Material.class, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "IDMATERIAL")
    private Material material;

    @Basic(optional = false)
    @Column(name = "QUANTIDADE", scale = 3, precision = 12)
    private int quantidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public ProdutoMaterial(Produto produto, Material material, int quantidade) {
        this.produto = produto;
        this.material = material;
        this.quantidade = quantidade;
    }

    public ProdutoMaterial() {

    }
}
