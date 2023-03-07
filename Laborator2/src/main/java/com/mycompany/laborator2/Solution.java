/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laborator2;

import java.util.Objects;

/**
 *
 * @author Miruna
 */
public class Solution {

    private Problem problem;

    /**
     *
     * @param problem
     * @return
     */
    public boolean solveProblem(Problem problem) {
        AlgorithmHelper[] roadHelper = new AlgorithmHelper[3 * problem.getRoads().length];
        int counterRoadHelper = 0;
        int[] takenRoads = new int[problem.getRoads().length];
        if (problem.isValid() == false) {
            {
                System.out.println("Problema nu este valida");
                return false;
            }
        } else {
            System.out.println("Problema este valida");
            System.out.println(problem.getStart());
            roadHelper[0] = new AlgorithmHelper(problem.getStart());
            /**
             * The algorithm finishes when we found the destination (return
             * true) or we reached the end of the array.
             */
            for (int i = 0; problem.getRoads()[i] != null; i++) {
                /**
                 * Check if we found a roads from the destination.
                 */
                if (roadHelper[0].getNextLocation().getName() == "default") {
                    if (problem.getRoads()[i].getA() == problem.getStart()) {
                        roadHelper[counterRoadHelper].setNextLocation(problem.getRoads()[i].getB());
                        System.out.println(roadHelper[counterRoadHelper].getNextLocation());
                        counterRoadHelper++;
                        roadHelper[counterRoadHelper] = new AlgorithmHelper(roadHelper[counterRoadHelper - 1].getNextLocation());
                        takenRoads[i] = 1;
                        i = 0;
                    }
                    if (problem.getRoads()[i].getB() == problem.getStart()) {
                        roadHelper[counterRoadHelper].setNextLocation(problem.getRoads()[i].getA());
                        System.out.println(roadHelper[counterRoadHelper].getNextLocation());
                        counterRoadHelper++;
                        roadHelper[counterRoadHelper] = new AlgorithmHelper(roadHelper[counterRoadHelper - 1].getNextLocation());
                        takenRoads[i] = 1;
                        i = 0;
                    }
                } else {
                    /**
                     * We are searching for another road from currentLocation.,
                     * we check a-b, but also b-a. The roads must not be taken.
                     *
                     */
                    if (takenRoads[i] == 0) {
                        if (problem.getRoads()[i].getA() == roadHelper[counterRoadHelper].getCurrentLocation() && problem.getRoads()[i].getB() != roadHelper[counterRoadHelper].getPreviousLocation()) {
                            /**
                             * We found a road that connects. We must check if
                             * it is the destination.
                             */
                            roadHelper[counterRoadHelper].setNextLocation(problem.getRoads()[i].getB());
                            counterRoadHelper++;
                            roadHelper[counterRoadHelper] = new AlgorithmHelper(roadHelper[counterRoadHelper - 1].getNextLocation());
                            if (roadHelper[counterRoadHelper].getCurrentLocation() == problem.getDestination()) {
                                System.out.println(roadHelper[counterRoadHelper].getCurrentLocation());
                                return true;
                            }
                            System.out.println(roadHelper[counterRoadHelper].getCurrentLocation());
                            takenRoads[i] = 1;
                            i = 0;
                        } else if (problem.getRoads()[i].getB() == roadHelper[counterRoadHelper].getCurrentLocation() && problem.getRoads()[i].getA() != roadHelper[counterRoadHelper].getPreviousLocation()) {
                            /**
                             * We found a road that connects. We must check if
                             * it is the destination.
                             */
                            roadHelper[counterRoadHelper].setNextLocation(problem.getRoads()[i].getA());
                            counterRoadHelper++;
                            roadHelper[counterRoadHelper] = new AlgorithmHelper(roadHelper[counterRoadHelper - 1].getNextLocation());
                            if (roadHelper[counterRoadHelper].getCurrentLocation() == problem.getDestination()) {
                                System.out.println(roadHelper[counterRoadHelper].getCurrentLocation());
                                return true;
                            }
                            System.out.println(roadHelper[counterRoadHelper].getCurrentLocation());
                            takenRoads[i] = 1;
                            i = 0;
                        } else {
                            /**
                             * There is no road that connects, we must go back.
                             */
                            counterRoadHelper--;
                            System.out.println("Revenim la " + roadHelper[counterRoadHelper].getCurrentLocation());
                            i = 0;
                        }
                    }
                }
            }
        }
        /**
         * If the it didn't reuturn true it means that we didn't reach the destination.
         */
        return false;
    }

    /**
     *
     */
    public Solution() {
    }

    /**
     *
     * @param problem
     */
    public Solution(Problem problem) {
        this.problem = problem;
    }

    /**
     *
     * @return
     */
    public Problem getProblem() {
        return problem;
    }

    /**
     *
     * @param problem
     */
    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.problem);
        return hash;
    }

    /**
     *
     * @param obj
     * @return
     */
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
        final Solution other = (Solution) obj;
        return Objects.equals(this.problem, other.problem);
    }

}
