package br.com.crescer.exerciciosaula4.POJOS;

import br.com.crescer.exerciciosaula4.POJOS.Material;
import br.com.crescer.exerciciosaula4.POJOS.Produto;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-13T11:50:57")
@StaticMetamodel(ProdutoMaterial.class)
public class ProdutoMaterial_ { 

    public static volatile SingularAttribute<ProdutoMaterial, Produto> produto;
    public static volatile SingularAttribute<ProdutoMaterial, Material> material;
    public static volatile SingularAttribute<ProdutoMaterial, Long> id;
    public static volatile SingularAttribute<ProdutoMaterial, Integer> quantidade;

}