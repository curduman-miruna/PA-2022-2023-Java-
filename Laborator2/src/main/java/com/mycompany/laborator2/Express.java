/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laborator2;

/**
 *
 * @author Miruna
 */
public class Express extends Road {


    public Express() {
    }


    public Express(String Name, Location a, Location b, int km) {
        this.setName(Name);
        this.setA(a);
        this.setB(b);
        this.setKilometers(km);
        this.setType("Express");
    }
}
