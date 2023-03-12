/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.laborator3;

/**
 *
 * @author Miruna
 */
public class Laborator3 {

    public static void main(String[] args) {
        Node person = new Person("Ana", 233, 56);
        Node otherPerson = new Person("Maria", 234, 65);
        Node company = new Company("Altex", 2344);
        Network network = new Network();
        network.addNode(person);
        network.addNode(otherPerson);
        network.addNode(company);
        person.addRelationship(otherPerson, "best-friend");
        person.addRelationship(company, "boss");
        System.out.println(person.toString());
        System.out.println(network.toString());
    }
}
