package br.com.crescer.exerciciosaula4.DAO;

import br.com.crescer.exerciciosaula4.POJOS.Cliente;
import javax.persistence.EntityManager;

public class ClienteDAO extends GenericDAO<Long, Cliente> {

    public ClienteDAO(EntityManager entity) {
        super(entity);
    }
}
