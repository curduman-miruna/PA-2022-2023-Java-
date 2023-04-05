/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laborator7;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miruna
 */
import java.util.ArrayList;
import java.util.List;

public class Exploration {

    private final SharedMemory mem = new SharedMemory(10); // initialize with 10 tokens
    private final ExplorationMap map = new ExplorationMap(10); // initialize with 10x10 cells
    private final List<Robot> robots = new ArrayList<>();

    public void start() {
        for (Robot robot : robots) {
            Thread thread = new Thread(robot);
            thread.start();
        }
    }

    public void addRobot(Robot robot) {
        robots.add(robot);
    }

}
