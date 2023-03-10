/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laborator2;

import java.util.Objects;

/**
 *
 * @author Miruna
 */
public class Location {

    private String name;
    private double x;
    private double y;


    public Location() {
    }


    public Location(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.name);
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
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
        final Location other = (Location) obj;
        if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
            return false;
        }
        if (Double.doubleToLongBits(this.y) != Double.doubleToLongBits(other.y)) {
            return false;
        }
        return Objects.equals(this.name, other.name);
    }


    @Override
    public String toString() {
        return name;
    }


    public String getName() {
        return name;
    }


    public double getX() {
        return x;
    }


    public double getY() {
        return y;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setX(double x) {
        this.x = x;
    }


    public void setY(double y) {
        this.y = y;
    }

}
