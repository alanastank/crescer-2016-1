package br.com.crescer.exerciciosaula4.DAO;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class GenericDAO<PK, Table> implements ICrud<PK, Table>{

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

    @Override
    public void insert(Table entity) {
        em.persist(entity);
    }

    @Override
    public void update(Table entity) {
        em.merge(entity);
    }

    @Override
    public void delete(Table entity) {
        em.remove(entity);
    }

    //http://www.devmedia.com.br/crud-completo-com-hibernate-e-jpa/32711
    @Override
    public List<Table> listAll() {
        return em.createQuery(String.format("SELECT T FROM %p t", getTypeClass())).getResultList();
    }

    private Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[1];
        return clazz;
    }

}
