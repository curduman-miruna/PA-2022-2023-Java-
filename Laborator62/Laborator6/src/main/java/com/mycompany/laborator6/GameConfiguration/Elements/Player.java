package com.mycompany.laborator6.GameConfiguration.Elements;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.awt.Color;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {

    private Color color;
    @JsonSerialize(contentUsing = Line2DSerializer.class)
    private List<Line2D> playerLines = new ArrayList<>();

    public Player() {
        // Generate a random RGB color
        Random random = new Random();
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        this.color = new Color(r, g, b);
    }

    public Color getColor() {
        return color;
    }

    public List<Line2D> getPlayerLines() {
        return playerLines;
    }

    public void setPlayerLines(List<Line2D> playerLines) {
        this.playerLines = playerLines;
    }

    public int containsLine(Dot currentDot, Dot lastDot){
        Line2D line = new Line2D.Double(lastDot.getX(), lastDot.getY(), currentDot.getX(), currentDot.getY());
        Line2D lineReversed =reverseLine(line);
        int counter=0;
        for (Line2D existingLine : playerLines) {
            if ((existingLine.getP1().equals(line.getP1())&&existingLine.getP2().equals(line.getP2())) || (existingLine.getP1().equals(lineReversed.getP1())&&existingLine.getP2().equals(lineReversed.getP2()))) {
                return counter;
            }
            counter++;
        }
        if(counter==0)
            return -2; // empty
        return -1; //not found
    }

    public void deleteLines(int id)
    {

        playerLines.remove(id);
    }

    public void addLine(Dot currentDot, Dot lastDot){
        Line2D line = new Line2D.Double(lastDot.getX(), lastDot.getY(), currentDot.getX(), currentDot.getY());
        playerLines.add(line);
    }

    public Line2D reverseLine(Line2D line){
       return new Line2D.Double(line.getX2(),line.getY2(),line.getX1(),line.getY1());
    }

    public boolean containsTriangle() {
        // Iterate over each combination of three lines
        for (int i = 0; i < playerLines.size(); i++) {
            for (int j = i + 1; j < playerLines.size(); j++) {
                for (int k = j + 1; k < playerLines.size(); k++) {
                    Line2D line1 = playerLines.get(i);
                    Line2D line2 = playerLines.get(j);
                    Line2D line3 = playerLines.get(k);

                    if(formsTriangle(line1,line2,line3)||formsTriangle(reverseLine(line1),reverseLine(line2),reverseLine(line3)))
                        return true;
                    else
                    if(formsTriangle(line1,line2,reverseLine(line3))||formsTriangle(line1,reverseLine(line2),line3)||formsTriangle(reverseLine(line1),line2,line3))
                        return true;
                    else
                    if(formsTriangle(reverseLine(line1),reverseLine(line2),line3)||formsTriangle(reverseLine(line1),line2,reverseLine(line3)))
                        return true;
                    else
                    if(formsTriangle(line1, reverseLine(line2), reverseLine(line3)))
                        return true;
                }
                }
        }

        // No triangle found
        return false;
    }

    public boolean formsTriangle(Line2D line1, Line2D line2, Line2D line3) {
        // Check if the endpoints form a closed loop
        return line1.getP1().equals(line2.getP2()) && line2.getP1().equals(line3.getP2()) && line3.getP1().equals(line1.getP2());
    }
}




