/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laborator3;

import java.util.Objects;

/**
 *
 * @author Miruna
 */
public class Designer extends Person{
    
    private double experience;
    private String styleDescription;

    public Designer(double experience, String styleDescription) {
        this.experience = experience;
        this.styleDescription = styleDescription;
    }

    public Designer(double experience, String styleDescription, String name, int id) {
        super(name, id);
        this.experience = experience;
        this.styleDescription = styleDescription;
    }

    public double getExperience() {
        return experience;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }

    public String getStyleDescription() {
        return styleDescription;
    }

    public void setStyleDescription(String styleDescription) {
        this.styleDescription = styleDescription;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.experience) ^ (Double.doubleToLongBits(this.experience) >>> 32));
        hash = 89 * hash + Objects.hashCode(this.styleDescription);
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
        final Designer other = (Designer) obj;
        if (Double.doubleToLongBits(this.experience) != Double.doubleToLongBits(other.experience)) {
            return false;
        }
        return Objects.equals(this.styleDescription, other.styleDescription);
    }
    
}
