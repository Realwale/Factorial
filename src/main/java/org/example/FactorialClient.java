package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class FactorialClient {
    public static void main(String[] args) {


        try{
            System.out.println("Client started...");

            Socket socket =new Socket("localhost", 1234);

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter a number: ");

            int number = Integer.parseInt(userInput.readLine());

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println(number);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.println(in.readLine());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}