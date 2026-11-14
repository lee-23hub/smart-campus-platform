package com.scasp.core.networking;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class CampusServer {

    private static final int PORT = 5000;

    public void startServer() {

        try (ServerSocket serverSocket =
                new ServerSocket(PORT)) {

            System.out.println("Campus Server started.");
            System.out.println("Waiting for connections...");

            while (true) {

                Socket clientSocket = serverSocket.accept();

                System.out.println(
                        "Client connected: "
                        + clientSocket.getInetAddress()
                );

                clientSocket.close();
            }

        } catch (IOException e) {
            System.out.println(
                    "Server error: " + e.getMessage()
            );
        }
    }
}