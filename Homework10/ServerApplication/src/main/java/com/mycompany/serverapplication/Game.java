/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.serverapplication;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Board board;
    private final List<Player> players;
    private int currentPlayerIndex;
    private boolean ended;

    private int initialTime; // Timpul inițial pentru fiecare jucător (în secunde)
    private int remainingTime; // Timpul rămas pentru jucătorul curent (în secunde)
    private long startTime; // Timpul de start al jocului sau al mutării curente (în milisecunde)

    public Game(int boardSize) {
        board = new Board(boardSize);
        createGame(600);
        players = new ArrayList<>();
        currentPlayerIndex = 0;
        ended=false;
    }

    public int isEnded() {
        return ended?1:0;
    }
    

    public void createGame(int initialTime) {
        this.initialTime = initialTime;
        this.remainingTime = initialTime;
        board.initialize();
        this.startTime = System.currentTimeMillis(); // Setăm timpul de start la momentul creării jocului
    }

    public Player playerByName(String name) {
        for (Player player : players) {
            if (player.getName() == name) {
                return player;
            }
        }
        return null;
    }

    public String otherPlyerName(String name) {
        for (Player player : players) {
            if (player.getName() != name) {
                return player.getName();
            }
        }
        return null;
    }

    public void addPlayer(String name, char mark) {
        if (players.size() < 2) {
            Player player = new Player(name, mark);
            players.add(player);
        } else {
            System.out.println("Numărul maxim de jucători a fost atins. Nu se mai pot adăuga jucători noi.");
        }
    }

    public boolean submitMove(Player currentPlayer, int row, int col, char mark) {

        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - startTime;
        remainingTime -= elapsedTime / 1000; // Convertim milisecundele în secunde

        if (remainingTime <= 0) {
            System.out.println(currentPlayer.getName() + " has run out of time. Game over!");
            // Implementați acțiunile necesare pentru încheierea jocului
            return true;
        }

        // Actualizăm timpul de start pentru următoarea mutare
        startTime = System.currentTimeMillis();

        if (board.isValidMove(row, col, mark)) { // Verifică dacă mutarea este validă în conformitate cu regulile jocului
            board.makeMove(row, col, mark);
            if (board.isWinningMove(row, col, mark)) {
                System.out.println(currentPlayer.getName() + " has won the game!");
                this.ended=true;
                return true;
            } else if (board.isBoardFull()) {
                System.out.println("It's a draw!");
                return true;
            } else {
                return true;
            }
        } else {
            System.out.println("Invalid move. Try again.");
        }

        return false;
    }

}
