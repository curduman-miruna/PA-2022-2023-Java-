/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.laborator2;

/**
 *
 * @author Miruna
 */
public class Laborator2 {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Location c1 = new Location();
        Location c2 = new Location("Vaslui", 10.0, 20.0);
        Location c3 = new Location("Galati", 10.0, 30.0);
        Location c4 = new Location("Barlad", 10, 25.5);
        Road[] roads = new Road[10];
        roads[0] = new Express("D12", c2, c3, 75);
        System.out.println(roads[0].toString());
        roads[1] = new Country("D14", c1, c3, 75);
        roads[2] = new Country("D13", c4, c3, 75);
        roads[3] = new Country("D16", c4, c3, 70);
        Problem p1 = new Problem(c2, c4, roads);
        System.out.println(p1.isValid());
        c1.setName("Iasi");
        c1.setX(0.0);
        c1.setY(0.0);
        System.out.println(c1);
        Solution solutionP1 = new Solution(p1);
        System.out.println(solutionP1.solveProblem(p1));
        //ShortestPath solt2 = new ShortestPath(p1);
        //System.out.println(solt2.solveProblem(p1));
        Road r1 = new Express("D24", c1, c2, 22);
        System.out.printf("The road with the name: %s (%s) is between %s and %s", r1.getName(), r1.getType(), r1.getA(), r1.getB());
    }

}
