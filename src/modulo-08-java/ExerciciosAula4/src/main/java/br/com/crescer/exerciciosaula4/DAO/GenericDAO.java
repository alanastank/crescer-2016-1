package br.com.crescer.exerciciosaula4.DAO;

import java.lang.reflect.ParameterizedType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenericDAO<PK, Table> {

    EntityManager em;

    public GenericDAO(EntityManager entityManager) {
        this.em = entityManager;
    }

    @SuppressWarnings("unchecked")
    public Table getById(PK pk) {
        return (Table) em.find(getTypeClass(), pk);
    }

    public void create(Table entity) {
        em.persist(entity);
    }

    public void save(Table entity) {
        em.merge(entity);
    }

    public void delete(Table entity) {
        em.remove(entity);
    }

    private Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[1];
        return clazz;
    }

}
