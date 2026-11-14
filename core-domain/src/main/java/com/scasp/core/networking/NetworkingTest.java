package com.scasp.core.networking;

public class NetworkingTest {

    public static void main(String[] args) {

        CampusServer server = new CampusServer();

        Thread serverThread = new Thread(() -> {
            server.startServer();
        });

        serverThread.setDaemon(true);
        serverThread.start();

        try {
            Thread.sleep(1000);

            CampusClient client = new CampusClient();
            client.connectToServer();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Test interrupted.");
        }
    }
}