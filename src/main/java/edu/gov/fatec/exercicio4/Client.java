package edu.gov.fatec.exercicio4;

import java.net.*;
import java.io.*;

public class Client {
    public static void requestHTTP(String host) throws IOException {
        Socket clientSocket = new Socket(host, 80);

        PrintWriter out = new PrintWriter(
                clientSocket.getOutputStream(),
                true);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));

        out.println("GET / HTTP/1.1");
        out.println("Host: " + host);
        out.println("Connection: close");
        out.println();

        String linha;

        while ((linha = in.readLine()) != null) {
            System.out.println(linha);
        }

        clientSocket.close();
    }

    public static void main(String[] args) {
        try {
            requestHTTP("www.aied.com.br");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
