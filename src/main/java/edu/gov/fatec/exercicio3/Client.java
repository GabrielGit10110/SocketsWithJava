package edu.gov.fatec.exercicio3;

import java.io.*;
import java.net.*;

public class Client {
    public static void request() throws IOException {
        Socket socket = new Socket("localhost", 9003);

        File file = new File("../../../../../resources/images/test.png");

        System.out.println(file.exists());
        System.out.println(file.getAbsolutePath());

        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        FileInputStream fis = new FileInputStream(file);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        try {
            out.writeUTF(file.getName());
            out.writeLong(file.length());

            byte[] buffer = new byte[4096];

            int bytes;

            while ((bytes = fis.read(buffer)) != -1) {
                out.write(buffer, 0, bytes);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        String response = in.readLine();
        System.out.println("Resposta do server: " + response);

        out.flush();
        fis.close();
        socket.close();

    }

    public static void main(String[] args) {
        try {
            request();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
