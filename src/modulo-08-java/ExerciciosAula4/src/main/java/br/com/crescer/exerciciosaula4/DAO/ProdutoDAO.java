package br.com.crescer.exerciciosaula4.DAO;

import br.com.crescer.exerciciosaula4.POJOS.Produto;
import javax.persistence.EntityManager;

public class ProdutoDAO extends GenericDAO<Long, Produto> {

    public ProdutoDAO(EntityManager entity) {
        super(entity);
    }

}
