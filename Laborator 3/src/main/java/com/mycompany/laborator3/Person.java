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
public class Person implements Node, Comparable<Person> {

    private String name;
    private int id;
    private double weight;
    private Map<Node, String> relationships = new HashMap<>();

    public Person(String name, int id, double weight) {
        this.name = name;
        this.id = id;
        this.weight = weight;
    }

    @Override
    public void addRelationship(Node node, String value) {
        relationships.put(node, value);
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Person other) {
        return this.name.compareTo(other.name);
        //what if the name is null?
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", id=" + id + ", weight=" + weight + ", relationships=" + relationships + '}';
    }

}
