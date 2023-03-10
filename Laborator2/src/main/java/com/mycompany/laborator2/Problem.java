/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laborator2;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Miruna
 */
public class Problem {

    /**
     * Problem: A tourist wants to see if it is possible to go from one location
     * to another using the given roads..
     */
    private Location start;
    private Location destination;
    private Road[] roads;

    public Problem(Location start, Location destination, Road[] roads) {
        this.roads = roads;
        this.start = start;
        this.destination = destination;
    }


    public Problem() {

    }

    /**
     * A problem is valid if the elements are not null, the destination is not
     * equal to the start and the roads don't repeat.
     *
     */
    public boolean isValid() {
        if (this.start == null && this.destination == null && this.roads == null) {
            {
                System.out.println("all null");
                return false;
            }
        } else if (this.start == null || this.destination == null || this.roads == null) {
            {
                System.out.println("some null");
                return false;
            }
        } else {
            if (this.start.equals(this.destination) == true) {
                System.out.println("location equals");
                return false;
            } else if (checkRoads() == false) {
                return false;
            } else {
                return true;
            }
        }
    }

    public boolean checkRoads() {
        if (this.roads == null) {
            return false;
        } else {

            for (int counter1 = 0; this.roads[counter1] != null; counter1++) {
                for (int counter2 = counter1 + 1; this.roads[counter2] != null; counter2++) {
                    if (this.roads[counter1].equals(this.roads[counter2]) == true) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public int populateAccesMap() {
        return 1;
    }

    public Location getStart() {
        return start;
    }


    public void setStart(Location start) {
        this.start = start;
    }


    public Location getDestination() {
        return destination;
    }


    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public Road[] getRoads() {
        return roads;
    }

    public void setRoads(Road[] roads) {
        this.roads = roads;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.start);
        hash = 83 * hash + Objects.hashCode(this.destination);
        hash = 83 * hash + Arrays.deepHashCode(this.roads);
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
        final Problem other = (Problem) obj;
        if (!Objects.equals(this.start, other.start)) {
            return false;
        }
        if (!Objects.equals(this.destination, other.destination)) {
            return false;
        }
        return Arrays.deepEquals(this.roads, other.roads);
    }

    @Override
    public String toString() {
        return "Problem{start=" + start + ", destination=" + destination + ", roads=" + roads + '}';
    }

}
