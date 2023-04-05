/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laborator7;

import java.util.ArrayList;
import java.util.List;

public class Robot implements Runnable {
    private String name;
    private boolean running;
    private ExplorationMap map;
    private List<Token> tokens;

    public Robot(String name, ExplorationMap map) {
        this.name = name;
        this.map = map;
        this.tokens = new ArrayList<>();
    }

    public void start() {
        running = true;
        new Thread(this).start();
    }

    public void stop() {
        running = false;
    }

    public synchronized void addTokens(List<Token> tokens) {
        this.tokens.addAll(tokens);
    }

    public synchronized List<Token> extractTokens(int count) {
        List<Token> extractedTokens = new ArrayList<>();
        int tokensToExtract = Math.min(count, tokens.size());
        for (int i = 0; i < tokensToExtract; i++) {
            extractedTokens.add(tokens.remove(0));
        }
        return extractedTokens;
    }

    @Override
    public void run() {
        while (running) {
            int row = (int) (Math.random() * map.getSize());
            int col = (int) (Math.random() * map.getSize());
            map.visit(row, col, this);
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "Robot " + name;
    }
}