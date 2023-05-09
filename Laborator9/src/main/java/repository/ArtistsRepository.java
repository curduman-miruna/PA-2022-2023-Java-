/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import static main.EntityManagerFactoryS.getEm;
import models.Artists;

/**
 *
 * @author Miruna
 */
public class ArtistsRepository extends AbstractRepository<Artists>{
      EntityManager  entityManager;

    public ArtistsRepository() {   
         super(Artists.class);
        entityManager=getEm();
    }

    public List<Artists> findByName(String name) {
        entityManager.getTransaction().begin();
        TypedQuery<Artists> query = entityManager.createNamedQuery("Artists.findByTitle", Artists.class);
        query.setParameter("name", name);
        List<Artists> resultList = query.getResultList();
        entityManager.getTransaction().commit();
        return resultList;
    }
}
