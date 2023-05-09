/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author Miruna
 */
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryS {
    private static  EntityManagerFactory factory;
    private static EntityManager em;
    
    public EntityManagerFactoryS(){
       factory = Persistence.createEntityManagerFactory("com.mycompany_Laborator9_jar_1.0-SNAPSHOTPU");
        em = factory.createEntityManager();
    }
    public static EntityManagerFactory getInstance() {
        return factory;
    }

    public static EntityManager getEm() {
        return em;
    }
    
    public static void closeFactory() {
        if (factory != null && factory.isOpen()) {
            factory.close();
        }
    }
}