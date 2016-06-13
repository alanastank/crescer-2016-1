package br.com.crescer.exerciciosaula4.DAO;

import br.com.crescer.exerciciosaula4.POJOS.Cidade;
import javax.persistence.EntityManager;

public class CidadeDAO extends GenericDAO<Long, Cidade> {

    public CidadeDAO(EntityManager entity) {
        super(entity);
    }

}
