package com.mycompany.serverapplication;

public class Player {
    private String name;
    private char mark;
    private int remainingTime=130;

    public Player(String name, char mark) {
        this.name = name;
        this.mark = mark;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }
    
    public String getName() {
        return name;
    }

    public char getMark() {
        return mark;
    }
}