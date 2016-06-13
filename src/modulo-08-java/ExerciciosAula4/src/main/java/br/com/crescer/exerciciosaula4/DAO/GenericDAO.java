package br.com.crescer.exerciciosaula4.DAO;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GenericDAO<PK, Table> {

    EntityManager em;
    EntityTransaction transaction;

    public GenericDAO(EntityManager entityManager) {
        this.em = entityManager;
        this.transaction = em.getTransaction();
    }

    @SuppressWarnings("unchecked")
    public Table getById(PK pk) {
        return (Table) em.find(getTypeClass(), pk);
    }

    public void insert(Table entity) {
        transaction.begin();
        em.persist(entity);
        transaction.commit();
    }

    public void update(Table entity) {
        transaction.begin();
        em.merge(entity);
        transaction.commit();
    }

    public void delete(Table entity) {
        transaction.begin();
        em.remove(entity);
        transaction.commit();
    }

    //http://www.devmedia.com.br/crud-completo-com-hibernate-e-jpa/32711
    public List<Table> listAll() {
        return em.createQuery(String.format("SELECT T FROM %p t", getTypeClass())).getResultList();
    }

    private Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[1];
        return clazz;
    }

}
