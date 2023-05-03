package compulsory.repository;

import compulsory.entity.RammsteinEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class RammsteinRepository {
    private EntityManager entityManager;
    public RammsteinRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(RammsteinEntity entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    public RammsteinEntity findById(int id) {
        return entityManager.find(RammsteinEntity.class, id);
    }

    public List<RammsteinEntity> findBySongName(String name) {
        entityManager.getTransaction().begin();
        TypedQuery<RammsteinEntity> query = entityManager.createNamedQuery("RammsteinEntity.findByName", RammsteinEntity.class);
        query.setParameter("songName", "%" + name + "%");
        List<RammsteinEntity> resultList = query.getResultList();
        entityManager.getTransaction().commit();
        return resultList;
    }

    public List<RammsteinEntity> findByAlbum(String name) {
        entityManager.getTransaction().begin();
        TypedQuery<RammsteinEntity> query = entityManager.createNamedQuery("RammsteinEntity.findByAlbum", RammsteinEntity.class);
        query.setParameter("album", "%" + name + "%");
        List<RammsteinEntity> resultList = query.getResultList();
        entityManager.getTransaction().commit();
        return resultList;
    }

}
