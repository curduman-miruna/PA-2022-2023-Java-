/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package main;

import java.util.ArrayList;
import com.github.javafaker.Faker;
import java.util.List;
import javax.persistence.EntityTransaction;
import static main.EntityManagerFactoryS.getEm;
import models.Albums;
import models.Artists;
import models.Genres;
import repository.AlbumsRepository;
import repository.ArtistsRepository;
import repository.GenresRepository;

/**
 *
 * @author Miruna
 */
public class Main {

    public static void main(String[] args) {
        Main app = new Main();
        app.run();
    }

    public void run() {
        EntityManagerFactoryS factory = new EntityManagerFactoryS();
        EntityTransaction transaction = getEm().getTransaction();
        
        
        GenresRepository genresRepository = new GenresRepository();
        var genre3 = new Genres(3,"Funk");
        genresRepository.create(genre3);
        List<Genres> genresList = new ArrayList<>();
        Genres genre1 = new Genres(1, "Rock");
        Genres genre2 = new Genres(2, "Pop");
        genresList.add(genre1);
        genresList.add(genre2);
   
        
        AlbumsRepository albumsRepository = new AlbumsRepository();
        String[] genreA1 = {"Pop", "Rock"};
        System.out.println(albumsRepository.findById(5));
        var a2 = new Albums(3, 1897, "My facvv", "who");
        a2.setGenresCollection(genresList);
        albumsRepository.create(a2);
        
        
        ArtistsRepository artistsRepository = new ArtistsRepository();
        Artists a1 = new Artists(3, "Taylor");
        artistsRepository.create(a1);
      
        
        //Populate with fake names
        Faker faker = new Faker();
        long start = System.currentTimeMillis();
        for (int i = 3; i < 500; i++) {
            Artists artist = new Artists(i, faker.name().fullName());
            artistsRepository.create(artist);

            int randomArtistId = faker.number().numberBetween(1, i);
            Artists randomArtist = artistsRepository.findById(randomArtistId);
            Albums album = new Albums(i, faker.number().numberBetween(1870, 2023), faker.pokemon().name(), randomArtist.getName());
            album.setArtistId(randomArtist);
            albumsRepository.create(album);
            
            Genres genre = new Genres(i,faker.music().genre());
            genresRepository.create(genre);
        }
        long end = System.currentTimeMillis();
        System.out.println("Execution time: " + (end - start) + "ms");
    }
}
