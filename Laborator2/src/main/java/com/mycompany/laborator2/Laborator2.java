/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.laborator2;

/**
 *
 * @author Miruna
 */
public class Laborator2 {

    public static void main(String[] args) {
        Location c1 = new Location();
        c1.setName("Iași");
        c1.setX(0.0);
        c1.setY(0.0);
        System.out.println(c1);
        Location c2 = new Location("Vaslui", 10.0, 20.0);
        System.out.println(c2);
        Road r1 = new Road();
        r1 = new Road("D24", RoadType.EXPRESS, c1, c2);
        System.out.printf("The road with the name: %s (%s) is between %s and %s",r1.getName(),r1.getType(),r1.getA(),r1.getB());
    }

}
