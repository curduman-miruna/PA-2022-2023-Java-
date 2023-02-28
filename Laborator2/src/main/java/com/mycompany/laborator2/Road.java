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
    private RoadType type;
    private Location a;
    private Location b;
    
    public Road(){
    };
    
    public Road(String name, RoadType type, Location a, Location b) {
        this.name = name;
        this.type = type;
        this.a=a;
        this.b=b;
    }

    public Location getA() {
        return a;
    }

    public Location getB() {
        return b;
    }
    
    public String getName() {
        return name;
    }

    public RoadType getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(RoadType type) {
        this.type = type;
    }

    public void setA(Location a) {
        this.a = a;
    }

    public void setB(Location b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "Road{" + "name=" + name + ", type=" + type + ", a=" + a + ", b=" + b + '}';
    }

    
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Road)) {
            return false;
        }
        Road other = (Road) obj;
        return name.equals(other.name);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.name);
        hash = 83 * hash + Objects.hashCode(this.type);
        hash = 83 * hash + Objects.hashCode(this.a);
        hash = 83 * hash + Objects.hashCode(this.b);
        return hash;
    }
    
}
