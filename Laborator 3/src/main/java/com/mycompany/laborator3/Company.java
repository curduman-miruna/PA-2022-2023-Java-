/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laborator3;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Miruna
 */
public class Company implements Node, Comparable<Company> {

    private String name;
    private int id;
    private int weight;
    private Map<Node, String> relationships = new HashMap<>();

    public Map<Node, String> getRelationships() {
        return relationships;
    }

    @Override
    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    public void setRelationships(Map<Node, String> relationships) {
        this.relationships = relationships;
    }

    public Company() {

    }

    public Company(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public void addRelationship(Node node, String value) {
        relationships.put(node, value);
    }
    //… toString, etc.

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Company{" + "name=" + name + ", id=" + id + ", relationships=" + relationships + '}';
    }

    @Override
    public int compareTo(Company other) {
        if(this.getWeight()==other.getWeight())
            return 0;
        else
            if(this.getWeight()>other.getWeight())
                return 1;
        return -1;
    }

}
