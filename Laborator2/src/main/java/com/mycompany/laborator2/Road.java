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

    /**
     *
     * @return
     */
    public Location getA() {
        return a;
    }

    /**
     *
     * @return
     */
    public int getKilometers() {
        return kilometers;
    }

    /**
     *
     * @param kilometers = how long the roads is
     */
    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    /**
     *
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @return
     */
    public Location getB() {
        return b;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name = What the road name is
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param a = one of the location the roads connects to
     */
    public void setA(Location a) {
        this.a = a;
    }

    /**
     *
     * @param b = one of the location the roads connects to
     */
    public void setB(Location b) {
        this.b = b;
    }

    /**
     *
     * @param type = type of the road
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     */
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

    /**
     *
     * @param obj = are the objects equal
     * @return
     */
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

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Road{" + "name=" + name + ", a=" + a + ", b=" + b + ", type=" + type + ", kilometers=" + kilometers + '}';
    }

}
