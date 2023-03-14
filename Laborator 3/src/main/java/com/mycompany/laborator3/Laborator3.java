/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.laborator3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Miruna
 */
public class Laborator3 {

    public static void main(String[] args) {
        Person person1 = new Person("Ana", 233);
        Person person2 = new Person("Maria", 234);
        Person person3 = new Person("Maria", 234);
        Company company1 = new Company("Altex", 2344);
        Network network = new Network();
        network.addNode(person1);
        network.addNode(person2);
        network.addNode(person3);
        network.addNode(company1);
        person1.addRelationship(person2, "best-friend");
        person1.addRelationship(person3, "friend");
        person1.addRelationship(company1, "boss");
        System.out.println(person1.toString());
        System.out.println(network.toString());
        List<Node> nodes = new ArrayList<>();
        nodes = network.getNodes();
        Collections.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node node1, Node node2) {
                if (node1.getWeight() == node2.getWeight()) {
                    return 0;
                } else if (node1.getWeight() > node2.getWeight()) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        System.out.println(nodes);
    }
}
