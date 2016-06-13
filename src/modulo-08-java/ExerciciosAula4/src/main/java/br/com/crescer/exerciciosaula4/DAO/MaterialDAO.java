package br.com.crescer.exerciciosaula4.DAO;

import br.com.crescer.exerciciosaula4.POJOS.Material;
import javax.persistence.EntityManager;

public class MaterialDAO extends GenericDAO<Long, Material> {
    
	public MaterialDAO(EntityManager entity) {
		super(entity);
	}
    
}
