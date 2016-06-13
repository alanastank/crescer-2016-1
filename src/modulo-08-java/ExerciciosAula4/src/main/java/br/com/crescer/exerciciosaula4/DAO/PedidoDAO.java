package br.com.crescer.exerciciosaula4.DAO;

import br.com.crescer.exerciciosaula4.POJOS.Pedido;
import javax.persistence.EntityManager;

public class PedidoDAO extends GenericDAO<Long, Pedido> {

    public PedidoDAO(EntityManager entity) {
        super(entity);
    }

}
