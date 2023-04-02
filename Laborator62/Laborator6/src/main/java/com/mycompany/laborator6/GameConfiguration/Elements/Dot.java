package com.mycompany.laborator6.GameConfiguration.Elements;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Objects;

public class Dot {
    private int x, y;
    private Ellipse2D oval = new Ellipse2D.Double(x-10, y-10, 20, 20);
    private boolean selected;
    public Dot(){

    }
    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
        this.updateOval();
        this.selected = false;
    }

    private void updateOval() {
        oval = new Ellipse2D.Double(x - 10, y - 10, 20, 20);
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Ellipse2D getOval() {
        return oval;
    }

    @JsonIgnore
    private transient Rectangle2D.Double bounds2D;

    public void setOval(Ellipse2D oval) {
        this.oval = oval;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dot dot = (Dot) o;
        return x == dot.x && y == dot.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}