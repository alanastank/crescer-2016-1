package br.com.crescer.exerciciosaula4.DAO;

import br.com.crescer.exerciciosaula4.POJOS.ProdutoMaterial;
import javax.persistence.EntityManager;

public class ProdutoMaterialDAO extends GenericDAO<Long, ProdutoMaterial> {

    public ProdutoMaterialDAO(EntityManager entity) {
        super(entity);
    }

}
