/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

/**
 *
 * @author Miruna
 */
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import main.EntityManagerFactoryS;

public abstract class AbstractRepository<T> {
    protected EntityManager entityManager;
    private final Class<T> entityClass;
    
    public AbstractRepository(Class<T> entityClass) {
        this.entityManager = EntityManagerFactoryS.getEm();;
        this.entityClass = entityClass;
    }
    
    public void create(T entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    public T findById(int id) {
        return entityManager.find(entityClass, id);
    }

    public List<T> findAll() {
        entityManager.getTransaction().begin();
        TypedQuery<T> query = entityManager.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e", entityClass);
        entityManager.getTransaction().commit();
        return query.getResultList();
    }
}
