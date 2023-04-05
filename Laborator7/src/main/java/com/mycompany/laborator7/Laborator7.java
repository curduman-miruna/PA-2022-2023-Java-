/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.laborator7;

/**
 *
 * @author Miruna
 */
public class Laborator7 {

    public static void main(String args[]) {
        var explore = new Exploration();
        ExplorationMap map = new ExplorationMap(10);
        explore.addRobot(new Robot("Wall-E",map));
        explore.addRobot(new Robot("R2D2",map));
        explore.addRobot(new Robot("Optimus Prime",map));
        explore.start();
    }
}
