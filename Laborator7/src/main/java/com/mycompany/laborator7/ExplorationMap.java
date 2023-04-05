/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laborator7;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.concurrent.locks.*;
import com.mycompany.laborator7.Token;

public class ExplorationMap {

    private final Cell[][] matrix;
    private final ReentrantLock[][] locks;
    private final int size;

    class Cell {

        private final List<Token> tokens;
        private boolean visited;

        public Cell(List<Token> tokens) {
            this.tokens = tokens;
        }

        public List<Token> getTokens() {
            return tokens;
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        public synchronized void addToken(Token token) {
            tokens.add(token);
        }

        public synchronized Token removeToken() {
            if (tokens.isEmpty()) {
                return null;
            }
            return tokens.remove(0);
        }

        @Override
        public String toString() {
            return visited ? "[X]" : "[ ]";
        }
    }

    public ExplorationMap(int size) {
        this.size = size;
        matrix = new Cell[size][size];
        locks = new ReentrantLock[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = new Cell(null);
                locks[i][j] = new ReentrantLock();
            }
        }
    }

    public synchronized boolean visit(int row, int col, Robot robot) {
        if (!matrix[row][col].isVisited()) {
            List<Token> tokens = robot.extractTokens(3);
            matrix[row][col].addToken((Token) tokens);
            matrix[row][col].setVisited(true);
            System.out.println(robot + " visited cell (" + row + ", " + col + ") and found tokens " + tokens);
            return true;
        } else {
            System.out.println(robot + " visited cell (" + row + ", " + col + ") but it was already visited");
            return false;
        }
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(matrix[i][j]);}}
        return sb.toString();
}
            
        
}
