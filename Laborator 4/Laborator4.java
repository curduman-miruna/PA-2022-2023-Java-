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

        Faker faker = new Faker();
        LinkedList<Student> students = IntStream.rangeClosed(6, 10)
                .mapToObj(i -> new Student(faker.name().firstName(), faker.name().lastName(), i))
                .collect(Collectors.toCollection(LinkedList::new));

        LinkedList<Student> sortedStudents = students.stream()
                .sorted()
                .collect(Collectors.toCollection(LinkedList::new));

        System.out.println(students);

        TreeSet<Project> projects = IntStream.rangeClosed(3, 6)
                .mapToObj(i -> new Project(faker.ancient().god(), faker.number().numberBetween(1, 10)))
                .collect(Collectors.toCollection(TreeSet::new));

        System.out.println(projects);
    }

}
