/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.laborator4;

import com.github.javafaker.Faker;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author Miruna
 */
public class Laborator4 {

    public static void main(String[] args) {

        Problem problem = new Problem(6);
        System.out.println(problem.toString());
        problem.getStatistics();
        problem.solveProblem();

        System.out.println();

        Problem problem2 = new Problem(10);
        System.out.println(problem2.toString());
        problem2.getStatistics();
        problem2.solveProblem();
    }

}
