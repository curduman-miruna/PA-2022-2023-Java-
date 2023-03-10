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
public class Road {

    private String name;
    private Location a;
    private Location b;
    private String type;
    private int kilometers;


    public Location getA() {
        return a;
    }


    public int getKilometers() {
        return kilometers;
    }


    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }


    public String getType() {
        return type;
    }


    public Location getB() {
        return b;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setA(Location a) {
        this.a = a;
    }


    public void setB(Location b) {
        this.b = b;
    }


    public void setType(String type) {
        this.type = type;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.name);
        hash = 53 * hash + Objects.hashCode(this.a);
        hash = 53 * hash + Objects.hashCode(this.b);
        hash = 53 * hash + Objects.hashCode(this.type);
        hash = 53 * hash + this.kilometers;
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
        final Road other = (Road) obj;
        if (this.kilometers != other.kilometers) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.a, other.a)) {
            return false;
        }
        return Objects.equals(this.b, other.b);
    }


    @Override
    public String toString() {
        return "Road{" + "name=" + name + ", a=" + a + ", b=" + b + ", type=" + type + ", kilometers=" + kilometers + '}';
    }

}
