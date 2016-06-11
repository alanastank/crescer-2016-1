/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package run;

import br.com.cwi.aulas.aula4.Entity.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AppRun {

    final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER16");
    final static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {

        // Criar pessoas no banco 
        /* em.getTransaction().begin();
        Pessoa pessoa = new Pessoa();
        pessoa.setNmPessoa("Testee");
        em.persist(pessoa);
        em.getTransaction().commit();*/
        
        // Listar todas pessoas registradas  
        /* Query query = em.createQuery("SELECT p FROM Pessoa p");
        List<Pessoa> pessoas = query.getResultList();
        for (Pessoa p : pessoas) {
            System.out.println(p.getNmPessoa());
        }*/
        
//        Query query = em.createNamedQuery("Pessoa.findAll");
        
        
        Query query = em.createNamedQuery("Pessoa.findByName");


        em.close();
        emf.close();
    }

}
