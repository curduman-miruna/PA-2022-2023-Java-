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

    /**
     *
     * @param currentLocation
     */
    public AlgorithmHelper(Location currentLocation) {
        this.currentLocation = currentLocation;
        this.nextLocation = defaultLocation();
        this.previousLocation = defaultLocation();
    }

    /**
     *
     * @param currentLocation
     * @param nextLocation
     */
    public AlgorithmHelper(Location currentLocation, Location nextLocation) {
        this.currentLocation = currentLocation;
        this.nextLocation = nextLocation;
        this.previousLocation = defaultLocation();
    }

    /**
     *
     * @param currentLocation
     * @param nextLocation
     * @param previousLocation
     */
    public AlgorithmHelper(Location currentLocation, Location nextLocation, Location previousLocation) {
        this.currentLocation = currentLocation;
        this.nextLocation = nextLocation;
        this.previousLocation = previousLocation;
    }

    /**
     *
     * @return
     */
    public Location getCurrentLocation() {
        return currentLocation;
    }

    /**
     *
     * @param currentLocation
     */
    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    /**
     *
     * @return
     */
    public Location getNextLocation() {
        return nextLocation;
    }

    /**
     *
     * @param nextLocation
     */
    public void setNextLocation(Location nextLocation) {
        this.nextLocation = nextLocation;
    }

    /**
     *
     * @return
     */
    public Location getPreviousLocation() {
        return previousLocation;
    }

    /**
     *
     * @param previousLocation
     */
    public void setPreviousLocation(Location previousLocation) {
        this.previousLocation = previousLocation;
    }

}
