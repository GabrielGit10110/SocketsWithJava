package edu.gov.fatec.exercicio2;

import java.io.*;
import java.net.*;

public class ThreadServer implements Runnable {
    Socket clientSocket;
    ServerSocket serverSocket;
    int clientNum;

    public ThreadServer(Socket clientSocket, ServerSocket serverSocket, int clientNum) {
        this.clientSocket = clientSocket;
        this.serverSocket = serverSocket;
        this.clientNum = clientNum;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String msg;

            while ((msg = in.readLine()) != null) {
                System.out.println("Mensagem do Client-" + clientNum + ":\t" + msg);

                if (msg.equals("Hello World!")) {
                    System.out.println("Chegou em Hello World!");
                    out.println("Mas que mensagem mais generica ein...");
                }

                if (msg.equals("teste")) {
                    System.out.println("Chegou em teste");
                    out.println("O que voce quer testar exatamente??");
                }

                if (msg.equals("SHUTDOWN")) {
                    serverSocket.close();
                    break;
                }

                out.println("Server recebeu a mensagem: " + "\"" + msg + "\"");
            }

            System.out.println("Cliente " + this.clientNum + " desconectado.");

        } catch (IOException e) {
            System.out.println("Cliente " + this.clientNum + " desconectado.");

        }

    }

}
