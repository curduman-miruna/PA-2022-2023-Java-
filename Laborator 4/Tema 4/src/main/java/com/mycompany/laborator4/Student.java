/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laborator4;

import java.util.Objects;
import com.github.javafaker.Faker;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author Miruna
 */
public class Student implements Comparable<Student> {

    private String firstName;
    private String lastName;
    private LinkedList<Project> admissibleProjects;
    private int id;

    public Student() {
    }

    public Student(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        LinkedList<Project> defaultProjects = new LinkedList();
        Project defaultProject = new Project("Default", 0);
        defaultProjects.add(defaultProject);
        this.admissibleProjects = defaultProjects;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstname(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastname(String lastname) {
        this.lastName = lastname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LinkedList<Project> getAdmissibleProjects() {
        return admissibleProjects;
    }

    public void setAdmissibleProjects(LinkedList<Project> admissibleProjects) {
        this.admissibleProjects = admissibleProjects;
    }

    public void addAdmissibleProjects(Project project) {
        Project defaultProject = new Project("Default", 0);
        if (this.admissibleProjects.contains(defaultProject)) {
            this.admissibleProjects.remove(defaultProject);
        }
        this.admissibleProjects.add(project);
    }

    public static Comparator<Student> getComparator() {
        return new Comparator<Student>() {
            @Override
            public int compare(Student student1, Student student2) {
                return student1.firstName.compareTo(student2.firstName);
            }
        };

    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.firstName);
        hash = 97 * hash + Objects.hashCode(this.lastName);
        hash = 97 * hash + this.id;
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
        final Student other = (Student) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        return Objects.equals(this.lastName, other.lastName);
    }

    @Override
    public String toString() {
        return "Student{" + "firstName=" + firstName + ", lastName=" + lastName + ", admissibleProjects=" + admissibleProjects + ", id=" + id + '}';
    }

    public String toString2() {
        return firstName + " " + lastName;
    }

    @Override
    public int compareTo(Student other) {
        return this.firstName.compareTo(other.lastName);

    }
}
