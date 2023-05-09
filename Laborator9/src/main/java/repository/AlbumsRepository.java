/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.io.Serializable;
import java.util.Arrays;
import javax.persistence.EntityManager;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import static main.EntityManagerFactoryS.getEm;
import models.Albums;
import org.apache.commons.lang3.ArrayUtils;

/**
 *
 * @author Miruna
 */
public class AlbumsRepository extends AbstractRepository<Albums>{
      EntityManager  entityManager;

    public AlbumsRepository() {   
         super(Albums.class);
        entityManager=getEm();
    }

    public List<Albums> findByName(String name) {
        entityManager.getTransaction().begin();
        TypedQuery<Albums> query = entityManager.createNamedQuery("Albums.findByName", Albums.class);
        query.setParameter("name", name);
        List<Albums> resultList = query.getResultList();
        entityManager.getTransaction().commit();
        return resultList;
    }

    public List<Albums> findByArtist(String artist) {
        entityManager.getTransaction().begin();
        TypedQuery<Albums> query = entityManager.createNamedQuery("Albums.findByArtist", Albums.class);
        query.setParameter("artist", artist);
        List<Albums> resultList = query.getResultList();
        entityManager.getTransaction().commit();
        return resultList;
    }
   
}

