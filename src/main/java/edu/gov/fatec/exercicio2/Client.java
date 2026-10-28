package edu.gov.fatec.exercicio2;

import java.io.*;
import java.net.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Client {
    public static void request() throws IOException {
        Socket socket = new Socket("localhost", 9002);

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        Scanner input = new Scanner(System.in);

        try {
            System.out.println("Digite o que sera enviado para o server na porta 9002: ");
            out.println(input.nextLine());

        } catch (NoSuchElementException e) {
            System.out.println("Ctrl+C detectado. Encerrando a conexao...");
        }

        String response = in.readLine();
        System.out.println("Resposta do server: " + response);

        socket.close();
        input.close();
    }

    public static void main(String[] args) {
        try {
            request();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
