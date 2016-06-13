package br.com.crescer.exerciciosaula4.DAO;

import br.com.crescer.exerciciosaula4.POJOS.PedidoItem;
import javax.persistence.EntityManager;

public class PedidoItemDAO extends GenericDAO<Long, PedidoItem> {

    public PedidoItemDAO(EntityManager entity) {
        super(entity);
    }

}
