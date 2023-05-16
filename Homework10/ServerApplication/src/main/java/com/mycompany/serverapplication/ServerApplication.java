/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.serverapplication;

/**
 *
 * @author Miruna
 */
public class ServerApplication {

    public static void main(String[] args) {
        int port = 8018; // Specify the desired port number
        GameServer server = new GameServer(port);
        server.start();
    }
}
