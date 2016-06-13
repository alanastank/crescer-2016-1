package br.com.crescer.exerciciosaula4.POJOS;

import br.com.crescer.exerciciosaula4.POJOS.Pedido;
import br.com.crescer.exerciciosaula4.POJOS.Produto;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-13T11:50:57")
@StaticMetamodel(PedidoItem.class)
public class PedidoItem_ { 

    public static volatile SingularAttribute<PedidoItem, Double> precoUnitario;
    public static volatile SingularAttribute<PedidoItem, String> situacao;
    public static volatile SingularAttribute<PedidoItem, Produto> produto;
    public static volatile SingularAttribute<PedidoItem, Pedido> pedido;
    public static volatile SingularAttribute<PedidoItem, Long> id;
    public static volatile SingularAttribute<PedidoItem, Integer> quantidade;

}