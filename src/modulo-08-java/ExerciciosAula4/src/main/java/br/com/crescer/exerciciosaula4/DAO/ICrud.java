package br.com.crescer.exerciciosaula4.DAO;

import java.util.List;
import javax.persistence.Table;

public interface ICrud {

    public void insert();

    public void update();

    public void delete();

    public List<Table> listAll();

}
