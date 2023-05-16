/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.serverapplication;

/**
 *
 * @author Miruna
 */
public class Board {
    private char[][] cells;
    private int size;

    public Board(int size) {
        this.size = size;
        cells = new char[size][size];
    }

    public void initialize() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = '-';
            }
        }
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(cells[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isValidMove(int row, int col, char mark) {
        return row >= 0 && row < size && col >= 0 && col < size && cells[row][col] == '-';
    }


    public void makeMove(int row, int col, char mark) {
        cells[row][col] = mark;
    }

    public boolean isWinningMove(int row, int col, char mark) {
        // Verificare orizontală
        int count = 0;
        for (int c = col - 4; c <= col + 4; c++) {
            if (isValidPosition(row, c) && cells[row][c] == mark) {
                count++;
                if (count == 5) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        // Verificare verticală
        count = 0;
        for (int r = row - 4; r <= row + 4; r++) {
            if (isValidPosition(r, col) && cells[r][col] == mark) {
                count++;
                if (count == 5) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        // Verificare diagonală (/)
        count = 0;
        for (int i = -4; i <= 4; i++) {
            int r = row + i;
            int c = col + i;
            if (isValidPosition(r, c) && cells[r][c] == mark) {
                count++;
                if (count == 5) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        // Verificare antidiagonală (\)
        count = 0;
        for (int i = -4; i <= 4; i++) {
            int r = row + i;
            int c = col - i;
            if (isValidPosition(r, c) && cells[r][c] == mark) {
                count++;
                if (count == 5) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        return false;
    }


    public boolean isBoardFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (cells[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidPosition(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }



}
