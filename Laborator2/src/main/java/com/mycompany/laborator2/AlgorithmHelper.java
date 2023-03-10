/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laborator2;

/**
 *
 * @author Miruna
 */
public class AlgorithmHelper {

    private Location currentLocation;
    private Location nextLocation;
    private Location previousLocation;

    private Location defaultLocation() {
        Location defaultLocation = new Location("default", 0.0, 0.0);
        return defaultLocation;
    }


    public AlgorithmHelper(Location currentLocation) {
        this.currentLocation = currentLocation;
        this.nextLocation = defaultLocation();
        this.previousLocation = defaultLocation();
    }


    public AlgorithmHelper(Location currentLocation, Location nextLocation) {
        this.currentLocation = currentLocation;
        this.nextLocation = nextLocation;
        this.previousLocation = defaultLocation();
    }


    public AlgorithmHelper(Location currentLocation, Location nextLocation, Location previousLocation) {
        this.currentLocation = currentLocation;
        this.nextLocation = nextLocation;
        this.previousLocation = previousLocation;
    }


    public Location getCurrentLocation() {
        return currentLocation;
    }


    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }


    public Location getNextLocation() {
        return nextLocation;
    }


    public void setNextLocation(Location nextLocation) {
        this.nextLocation = nextLocation;
    }


    public Location getPreviousLocation() {
        return previousLocation;
    }


    public void setPreviousLocation(Location previousLocation) {
        this.previousLocation = previousLocation;
    }

}
