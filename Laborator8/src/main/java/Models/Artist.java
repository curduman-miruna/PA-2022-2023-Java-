/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Miruna
 */
public class Artist {

    private int id;
    private String name;

    public Artist(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Artist(String name) {
        this.id = 1;
        this.name = name;
    }

    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Artist " + name + " has the id " + id;
    }

}
