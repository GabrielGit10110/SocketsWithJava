package edu.gov.fatec.exercicio2;

import java.io.*;
import java.net.*;

public class Server {
    public static void openSocket() throws IOException {
        ServerSocket serverSocket = new ServerSocket(9002);
        System.out.println("Porta 9002 aberta. Esperando por conexoes...");

        int clientNum = 0;

        while (!serverSocket.isClosed()) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente " + clientNum + " conectado!");

                ThreadServer tS = new ThreadServer(clientSocket, serverSocket, clientNum);

                new Thread(tS).start();

                clientNum++;

            } catch (SocketException e) {
                System.out.println("Porta 9002 fechada...");
                break;
            }

        }

        serverSocket.close();

    }

    public static void main(String[] args) {
        try {
            openSocket();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
