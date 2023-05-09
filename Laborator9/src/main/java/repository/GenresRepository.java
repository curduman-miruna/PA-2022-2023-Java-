/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import static main.EntityManagerFactoryS.getEm;
import models.Genres;

/**
 *
 * @author Miruna
 */
public class GenresRepository extends AbstractRepository<Genres>{
      EntityManager  entityManager;

    public GenresRepository() {   
         super(Genres.class);
        entityManager=getEm();
    }
    public List<Genres> findByName(String name) {
        entityManager.getTransaction().begin();
        TypedQuery<Genres> query = entityManager.createNamedQuery("Genres.findByTitle", Genres.class);
        query.setParameter("name", name);
        List<Genres> resultList = query.getResultList();
        entityManager.getTransaction().commit();
        return resultList;
    }
}
