/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laborator3;

import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;

/**
 *
 * @author Miruna
 */
public class Person implements Node, Comparable<Person> {

    private String name;
    private LocalDate date;
    private int id;
    private int weight;
    private Map<Node, String> relationships = new HashMap<>();

    public Person() {

    }

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
        this.weight = 0;
    }

    @Override
    public void addRelationship(Node node, String value) {
        this.setWeight(this.getWeight() + 1);
        node.setWeight(node.getWeight() + 1);
        relationships.put(node, value);

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Map<Node, String> getRelationships() {
        return relationships;
    }

    public void setRelationships(Map<Node, String> relationships) {
        this.relationships = relationships;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Person other) {
        if (this.getWeight() == other.getWeight()) {
            return 0;
        } else if (this.getWeight() > other.getWeight()) {
            return 1;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", id=" + id + ", weight=" + weight + ", relationships=" + relationships + '}';
    }

}
