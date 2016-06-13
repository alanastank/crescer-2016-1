package br.com.crescer.exerciciosaula4.DAO;

import java.util.List;

public interface ICrud<PK, Table> {

    public void insert(Table entity);

    public void update(Table entity);

    public void delete(Table entity);

    public List<Table> listAll();

}
