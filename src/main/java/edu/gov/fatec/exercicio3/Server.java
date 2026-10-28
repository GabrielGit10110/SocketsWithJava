package edu.gov.fatec.exercicio3;

import java.io.*;
import java.net.*;

public class Server {
    public static void openSocket() throws IOException {
        ServerSocket serverSocket = new ServerSocket(9003);
        System.out.println("Porta 9003 aberta. Esperando por conexoes...");

        Socket clientSocket = serverSocket.accept();
        System.out.println("Cliente conectado!");

        DataInputStream in = new DataInputStream(clientSocket.getInputStream());

        FileOutputStream fos = new FileOutputStream("nova_img.png");

        System.out.println("titulo que vai ser recebida: " + in.readUTF());
        long fileSize = in.readLong();

        byte[] buffer = new byte[4096];

        long total = 0;

        while (total < fileSize) {
            int bytesRead = in.read(buffer);

            if (bytesRead == -1) {
                break;
            }

            fos.write(buffer, 0, bytesRead);

            total += bytesRead;
        }

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        out.println("Servidor recebeu a imagem com sucesso!");

        fos.close();
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
