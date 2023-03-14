/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laborator3;

/**
 *
 * @author Miruna
 */
public interface Node{
    
    String getName();
    int getId();
    void addRelationship(Node node, String relationship);
    void setWeight(int weight);
    default int getWeight() {
        return 0;
    }
}
