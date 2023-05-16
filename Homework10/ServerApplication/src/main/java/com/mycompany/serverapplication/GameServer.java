package com.mycompany.serverapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class GameServer {

    private final int port;
    private List<ClientThread> clients;
    private Game game;

    public GameServer(int port) {
        this.port = port;
        this.clients = new ArrayList<>();
    }

    public void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();

                // Read the name and mark from the client
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String name = reader.readLine();
                char mark = reader.readLine().charAt(0);

                ClientThread clientThread = new ClientThread(clientSocket, this, name, mark);
                clients.add(clientThread);
                clientThread.start();

                System.out.println("Client connected: " + clientSocket.getInetAddress() + " (Name: " + name + ", Mark: " + mark + ")");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        // Cleanup resources, stop the server, etc.
        System.out.println("Server stopped");
        System.exit(0);
    }

    public ClientThread OtherPlayer(String name) {
        for (ClientThread client : clients) {
            if (client.getUsername() == name) {
                return client;
            }
        }
        return null;
    }

    public void setOtherPlayerTurn(String name) {
        for (ClientThread client : clients) {
            if (client.getUsername() == name) {
                client.setTurn(true);
            }
        }
    }

    public void handleCommand(ClientThread client, String command) {
        if (command.equals("stop")) {
            stop();
        } else if (command.startsWith("create")) {
            if (game == null) {
                String[] parts = command.split(" ");
                if (parts.length >= 2) {
                    int boardSize = Integer.parseInt(parts[1]);
                    game = new Game(boardSize);
                    String name = client.getUsername();
                    char mark = client.getMark();
                    game.addPlayer(name, mark);
                    client.setTurn(true);
                    String message = "Game created with board size " + boardSize;
                    System.out.println(message);
                    client.sendMessage(message);
                } else {
                    System.out.println("Invalid create command. Usage: create <boardSize>");
                }
            } else {
                System.out.println("A game is already in progress");
            }
        } else if (command.startsWith("join")) {
            if (game != null) {
                String[] parts = command.split(" ");
                String name = client.getUsername();
                char mark = client.getMark();
                game.addPlayer(name, mark);
                String message = "Player " + name + " joined the game.";
                System.out.println(message);
                client.sendMessage(message);
            } else {
                String message = "No game is currently in progress";
                System.out.println(message);
                client.sendMessage(message);
            }
        } else if (command.startsWith("submit")) {
            if (game != null && client.isTurn() && game.isEnded() == 0) {
                String[] parts = command.split(" ");
                if (parts.length >= 4 && parts[0].equals("submit")) {
                    int row = Integer.parseInt(parts[1]);
                    int col = Integer.parseInt(parts[2]);
                    char mark = client.getMark();
                    boolean validMove = game.submitMove(game.playerByName(client.getUsername()), row, col, mark);
                    if (validMove) {
                         if(game.isEnded()==1)
                        {String message = "Player " + client.getUsername() + " won the game with the move at (" + row + ", " + col + ") " + client.getMark();
                        System.out.println(message);
                        client.sendMessage(message);
                        String message2 = "Player " + game.otherPlyerName(client.getUsername()) + "lost.";
                        System.out.println(message2);
                        ClientThread otherClient = OtherPlayer(game.otherPlyerName(client.getUsername()));
                        otherClient.sendMessage(message2);
                        }
                         else{
                        String message = "Player " + client.getUsername() + " submitted a move at (" + row + ", " + col + ") " + client.getMark();
                        System.out.println(message);
                        client.sendMessage(message);
                        String message2 = message + ". Player " + game.otherPlyerName(client.getUsername()) + ", is your turn now.";
                        System.out.println(message2);
                        ClientThread otherClient = OtherPlayer(game.otherPlyerName(client.getUsername()));
                        otherClient.sendMessage(message2);
                        client.setTurn(false);
                        setOtherPlayerTurn(game.otherPlyerName(client.getUsername()));}

                    } else {
                        String message = "Invalid move";
                        client.sendMessage(message);
                        System.out.println(message);
                    }
                } else {
                    String message = "Invalid submit command. Usage: submit <row> <col> <mark>";
                    client.sendMessage(message);
                    System.out.println(message);
                }
            } else {
                if (game == null) {
                    String message = "No game is currently in progress";
                    client.sendMessage(message);
                    System.out.println(message);
                } else if (game.isEnded() == 1) {
                    String message = "Game was ended";
                    client.sendMessage(message);
                    System.out.println(message);
                } else {
                    String message = "Is not " + client.getUsername() + " turn.";
                    client.sendMessage(message);
                    System.out.println(message);
                }
            }
        } else {
            String message = "Server received an unknown command: " + command;
            client.sendMessage(message);
            System.out.println(message);
        }
    }

}
