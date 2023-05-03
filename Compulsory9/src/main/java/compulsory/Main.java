package compulsory;

import compulsory.entity.RammsteinEntity;
import compulsory.repository.RammsteinRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.math.BigInteger;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main app = new Main();
        app.run();
    }
    public void run() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab9");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            RammsteinRepository repository = new RammsteinRepository(em);
            RammsteinEntity song1 = new RammsteinEntity(89, "Welt", "Single", "3:44", "2022-08-26");
            RammsteinEntity song2 = new RammsteinEntity(90, "Groß", "Single", "3:38", "2022-05-27");
            RammsteinEntity song3 = new RammsteinEntity(91, "Welt", "Single", "4:06", "2022-03-26");
            List<RammsteinEntity> matchingSongs = repository.findBySongName(song2.getSongName());
            System.out.println("attempting to add songs to database...");

            if (matchingSongs.isEmpty()){
                repository.create(song2);
                System.out.printf("added song to database!");
            }
            else System.out.println("found an existent song!");

            int searchedId = 29;
            String searhedAlbum = "Zeit";

            System.out.println("\nFound song with id " + searchedId + " is :" + repository.findById(searchedId));
            System.out.println("\n Full album of " + searhedAlbum +" is :" + repository.findByAlbum(searhedAlbum));
        }
        finally {
            if(transaction.isActive())
                transaction.rollback();
            em.close();
            emf.close();
        }

    }
}