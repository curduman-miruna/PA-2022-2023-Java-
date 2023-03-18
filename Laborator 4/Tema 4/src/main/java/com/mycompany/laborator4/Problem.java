/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laborator4;

import com.github.javafaker.Faker;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author Miruna
 */
public class Problem {

    private LinkedList<Student> students;
    private TreeSet<Project> projects;
    private LinkedList<Project> takenProjects;

    public Project getRandomProject(Student student) {
        Faker faker = new Faker();
        int listSize = this.projects.size();
        int randomNumber;
        randomNumber = faker.number().numberBetween(1, listSize);
        int counter = 1;
        for (Project p : this.projects) {
            if (counter == randomNumber) {
                if (student.getAdmissibleProjects().contains(p)) {
                    randomNumber = faker.number().numberBetween(counter, listSize + 1);
                } else {
                    student.addAdmissibleProjects(p);
                    return p;
                }
            } else {
                counter++;
            }
        }
        return null;
    }

    public Problem(int size) {
        Faker faker = new Faker();
        TreeSet<Project> projects = IntStream.rangeClosed(1, size)
                .mapToObj(i -> new Project(faker.name().lastName() + " - " + faker.ancient().god(), faker.number().numberBetween(1, 10)))
                .collect(Collectors.toCollection(TreeSet::new));
        Project defaultProject = new Project("Default", 0);
        projects.remove(defaultProject);
        this.projects = projects;

        LinkedList<Student> students = IntStream.rangeClosed(1, size)
                .mapToObj(i -> new Student(faker.name().firstName(), faker.name().lastName(), i))
                .collect(Collectors.toCollection(LinkedList::new));

        Collections.sort(students, Student.getComparator());
        this.students = students;

        for (Student s : this.students) {
            LinkedList<Project> favoriteProjects = IntStream.rangeClosed(1, faker.number().numberBetween(1, size+1))
                    .mapToObj(i -> getRandomProject(s))
                    .collect(Collectors.toCollection(LinkedList::new));
            s.setAdmissibleProjects(favoriteProjects);
        }

        LinkedList<Project> defaultProjects = new LinkedList();
        defaultProjects.add(defaultProject);
        this.takenProjects = defaultProjects;

    }

    public void solveProblem() {
        Project defaultProject = new Project("Default", 0);
        for (Student s : this.students) {
            LinkedList<Project> thisStundentProjects = new LinkedList();
            thisStundentProjects = s.getAdmissibleProjects();
            int tookProject = 0;
            for (Project p : thisStundentProjects) {
                if (this.takenProjects.contains(p) == false && p != null && tookProject == 0) {
                    if (this.takenProjects.contains(defaultProject)) {
                        this.takenProjects.remove(defaultProject);
                    }
                    this.takenProjects.add(p);
                    tookProject = 1;
                    System.out.println("Student " + s.getFirstName() + " " + s.getLastName() + " has project " + p.getName() + " - difficulty " + p.getDifficulty() + ".");
                }
            }
            if (tookProject == 0) {
                System.out.println("Unfortunate for student " + s.getFirstName() + " " + s.getLastName() + " all the projects he/she/they wanted were taken.");
            }
        }
    }

    public double getAverageAdmissibleProjects() {
        double averageAdmissibleProjects = this.students.stream()
                .mapToInt(student -> student.getAdmissibleProjects().size())
                .average()
                .orElse(Double.NaN);
        return averageAdmissibleProjects;
    }

    public void getStatistics() {

        double average = getAverageAdmissibleProjects();
        LinkedList<Student> selectedStudents = students.stream()
                .filter(student -> student.getAdmissibleProjects().size() < average)
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println("The average number of admissible projects is: " + this.getAverageAdmissibleProjects());
        System.out.print("The following students have the number of preferences lower than the average number of preferences: ");
        for (Student s : selectedStudents) {
            System.out.print(s.toString2() + ", ");
        }
        System.out.println();
    }

    public LinkedList<Student> getStudents() {
        return students;
    }

    public void setStudents(LinkedList<Student> students) {
        this.students = students;
    }

    public TreeSet<Project> getProjects() {
        return projects;
    }

    public void setProjects(TreeSet<Project> projects) {
        this.projects = projects;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.students);
        hash = 37 * hash + Objects.hashCode(this.projects);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Problem other = (Problem) obj;
        if (!Objects.equals(this.students, other.students)) {
            return false;
        }
        return Objects.equals(this.projects, other.projects);
    }

    @Override
    public String toString() {
        return "Problem has " + this.students.size() + " students [" + students + "] \nand " + this.projects.size() + " projects[" + projects + "].";
    }

}
