package br.com.crescer.exerciciosaula4.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenericDAO {

    static EntityManagerFactory emf;
    static EntityManager em;

    public GenericDAO() {
        emf = Persistence.createEntityManagerFactory("CRESCER16");
        em = emf.createEntityManager();
    }

    public void close() {
        em.close();
        emf.close();
    }

}
