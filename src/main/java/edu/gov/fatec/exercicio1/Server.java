package edu.gov.fatec.exercicio1;

import java.io.*;
import java.net.*;

public class Server {
    public static void openSocket() throws IOException {
        ServerSocket serverSocket = new ServerSocket(9001);
        System.out.println("Porta 9001 aberta. Esperando por conexoes...");

        Socket clientSocket = serverSocket.accept();
        System.out.println("Cliente conectado!");

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        try {
            String message = in.readLine();
            System.out.println("Mensagem do cliente: " + message);

        } catch (Exception e) {
            e.printStackTrace();
        }

        out.println("Servidor recebeu a mensagem com sucesso!");

        clientSocket.close();
        serverSocket.close();
    }

    public static void main(String[] args) {
        try {
            openSocket();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}