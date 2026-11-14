package com.scasp.core.networking;

import java.io.IOException;
import java.net.Socket;

public class CampusClient {

    private static final String HOST = "localhost";
    private static final int PORT = 5000;

    public void connectToServer() {

        try (Socket socket = new Socket(HOST, PORT)) {

            System.out.println("Connected to Campus Server.");
            System.out.println("Connection successful.");

        } catch (IOException e) {
            System.out.println(
                    "Connection failed: " + e.getMessage()
            );
        }
    }
}