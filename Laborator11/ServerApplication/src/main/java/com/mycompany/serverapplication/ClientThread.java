package com.mycompany.serverapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private final Socket clientSocket;
    private final GameServer gameServer;
    private boolean turn;
    private final String username;
    private final char mark;

    public ClientThread(Socket clientSocket, GameServer gameServer, String name, char mark) {
        this.clientSocket = clientSocket;
        this.gameServer = gameServer;
        this.username = name;
        this.mark = mark;
        this.turn = false;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            // Send the connection message to the client
            writer.println("You are now connected to the server.");

            String command;
            while ((command = reader.readLine()) != null) {
                gameServer.handleCommand(this, command);
            }

            reader.close();
            writer.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public char getMark() {
        return mark;
    }

    public String getUsername() {
        return username;
    }
    
    public boolean isTurn(){
    return this.turn;}
    public void setTurn(boolean turn){
    this.turn=turn;}

    public void sendMessage(String message) {
        try {
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
            writer.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
