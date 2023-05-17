package com.mycompany.clientapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GameClient {

    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 8018;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            System.out.println("Connected to server on " + SERVER_ADDRESS + ":" + SERVER_PORT);

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

            // Prompt the client to enter their name and mark
            System.out.print("Enter your name: ");
            String name = keyboard.readLine();
            System.out.print("Enter your mark [one character]: ");
            String mark = keyboard.readLine();

            // Send the name and mark to the server
            out.println(name);
            out.println(mark);

            String inputLine;
            while (true) {
                if (keyboard.ready()) {
                    inputLine = keyboard.readLine();
                    out.println(inputLine);
                    if (inputLine.equals("exit")) {
                        break;
                    }
                }
                // Check if there is any server response available
                if (in.ready()) {
                    String serverResponse = in.readLine();
                    System.out.println("Server response: " + serverResponse);
                }
            }

            in.close();
            out.close();
            keyboard.close();
            socket.close();
            System.out.println("Disconnected from server");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
