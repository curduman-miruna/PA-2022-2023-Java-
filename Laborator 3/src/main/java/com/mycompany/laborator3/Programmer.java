/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laborator3;

import java.util.Arrays;

/**
 *
 * @author Miruna
 */
public class Programmer extends Person {
    
    private String[] programmingLanguages;
    private int experience;

    public String[] getProgrammingLanguages() {
        return programmingLanguages;
    }

    public int getExperience() {
        return experience;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Arrays.deepHashCode(this.programmingLanguages);
        hash = 17 * hash + this.experience;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Programmer other = (Programmer) obj;
        if (this.experience != other.experience) {
            return false;
        }
        return Arrays.deepEquals(this.programmingLanguages, other.programmingLanguages);
    }

    public Programmer(String[] programmingLanguages, int experience) {
        this.programmingLanguages = programmingLanguages;
        this.experience = experience;
    }

    public Programmer(String[] programmingLanguages, int experience, String name, int id) {
        super(name, id);
        this.programmingLanguages = programmingLanguages;
        this.experience = experience;
    }
    
}
