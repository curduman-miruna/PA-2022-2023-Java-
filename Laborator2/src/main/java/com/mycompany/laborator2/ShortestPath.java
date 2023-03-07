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
public class ShortestPath {
    private Problem problem;

    /**
     *
     * @param problem
     * @return
     */
    public int solveProblem(Problem problem) {
        AlgorithmHelper[] roadHelper = new AlgorithmHelper[3 * problem.getRoads().length];
        int counterRoadHelper = 0;
        int[] takenRoads = new int[problem.getRoads().length];
        int[] dimensionPath = new int[problem.getRoads().length * 4];
        int pathNumber=0;
        int shortest = 9999;
        if (problem.isValid() == false) {
            {
                System.out.println("Problema nu este valida");
                return 0;
            }
        } else {
            System.out.println("Problema este valida");
            System.out.println(problem.getStart());
            roadHelper[0] = new AlgorithmHelper(problem.getStart());
            //Se termina daca am ajuns la capat sau locatia urmatoare e destinatia
            for (int i = 0; problem.getRoads()[i] != null; i++) {
                /*Verificare daca am pornit am gasit un drum cu start*/
                if (roadHelper[0].getNextLocation().getName() == "default") {
                    if (problem.getRoads()[i].getA() == problem.getStart()) {
                        roadHelper[counterRoadHelper].setNextLocation(problem.getRoads()[i].getB());
                        System.out.println("35" + roadHelper[counterRoadHelper].getNextLocation());
                        counterRoadHelper++;
                        roadHelper[counterRoadHelper] = new AlgorithmHelper(roadHelper[counterRoadHelper - 1].getNextLocation());
                        takenRoads[i] = 1;
                        dimensionPath[pathNumber]+= problem.getRoads()[i].getKilometers();
                        i = 0;
                        
                    }
                    if (problem.getRoads()[i].getB() == problem.getStart()) {
                        roadHelper[counterRoadHelper].setNextLocation(problem.getRoads()[i].getA());
                        System.out.println("42" + roadHelper[counterRoadHelper].getNextLocation());
                        counterRoadHelper++;
                        roadHelper[counterRoadHelper] = new AlgorithmHelper(roadHelper[counterRoadHelper - 1].getNextLocation());
                        takenRoads[i] = 1;
                        dimensionPath[pathNumber]+= problem.getRoads()[i].getKilometers();
                        i = 0;
                    }
                } else { //Ne mutam pe primul un drum gasit
                    if (takenRoads[i] == 0) {
                        if (problem.getRoads()[i].getA() == roadHelper[counterRoadHelper].getCurrentLocation() && problem.getRoads()[i].getB() != roadHelper[counterRoadHelper].getPreviousLocation()) {
                            roadHelper[counterRoadHelper].setNextLocation(problem.getRoads()[i].getB());
                            counterRoadHelper++;
                            roadHelper[counterRoadHelper] = new AlgorithmHelper(roadHelper[counterRoadHelper - 1].getNextLocation());
                            if (roadHelper[counterRoadHelper].getCurrentLocation() == problem.getDestination()) {
                                System.out.println("53" + roadHelper[counterRoadHelper].getCurrentLocation());
                                dimensionPath[pathNumber]+= problem.getRoads()[i].getKilometers();
                                if(shortest==0 || shortest > dimensionPath[pathNumber])
                                {shortest = dimensionPath[pathNumber];
                                 pathNumber++;
                                 takenRoads = new int[problem.getRoads().length];
                                 counterRoadHelper--;
                                System.out.println("Revenim la 70" + roadHelper[counterRoadHelper].getCurrentLocation());
                                i = 0;
                                }
                                }
                            takenRoads[i] = 1;
                            i = 0;
                        } else if (problem.getRoads()[i].getB() == roadHelper[counterRoadHelper].getCurrentLocation() && problem.getRoads()[i].getA() != roadHelper[counterRoadHelper].getPreviousLocation()) {
                            roadHelper[counterRoadHelper].setNextLocation(problem.getRoads()[i].getA());
                            counterRoadHelper++;
                            roadHelper[counterRoadHelper] = new AlgorithmHelper(roadHelper[counterRoadHelper - 1].getNextLocation());
                            if (roadHelper[counterRoadHelper].getCurrentLocation() == problem.getDestination()) {
                                System.out.println("63" + roadHelper[counterRoadHelper].getCurrentLocation());
                                dimensionPath[pathNumber]+= problem.getRoads()[i].getKilometers();
                                if(shortest==0 || shortest > dimensionPath[pathNumber])
                                {shortest = dimensionPath[pathNumber];
                                 pathNumber++;
                                 takenRoads = new int[problem.getRoads().length];
                                 takenRoads[i] = 1;
                                 counterRoadHelper--;
                                System.out.println("Revenim la 70" + roadHelper[counterRoadHelper].getCurrentLocation());
                                i = 0;
                                }
                                }
                            }
                            System.out.println("66" + roadHelper[counterRoadHelper].getCurrentLocation());
                            takenRoads[i] = 1;
                            i = 0;
                        } else {
                            counterRoadHelper--;
                            System.out.println("Revenim la 70" + roadHelper[counterRoadHelper].getCurrentLocation());
                            i = 0;
                        }
                    }
                }
            }
        return shortest;
        }

    /**
     *
     * @param problem
     */
    public ShortestPath(Problem problem) {
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
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.problem);
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
        final ShortestPath other = (ShortestPath) obj;
        return Objects.equals(this.problem, other.problem);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "ShortestPath{" + "problem=" + problem + '}';
    }
    
    
}
