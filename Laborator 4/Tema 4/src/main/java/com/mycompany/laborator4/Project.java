/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laborator4;

import java.util.Objects;

/**
 *
 * @author Miruna
 */
public class Project implements Comparable<Project> {

    private String name;
    private int difficulty;

    public Project() {
    }

    public Project(String name, int difficulty) {
        this.name = name;
        this.difficulty = difficulty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public int compareTo(Project other) {
        return this.name.compareTo(other.name);

    }

    @Override
    public String toString() {
        return "Project{" + "name=" + name + ", difficulty=" + difficulty + '}';
    }

}
