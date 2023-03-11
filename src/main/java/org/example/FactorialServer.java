package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class FactorialServer {
    public static void main(String[] args) {

        try{
            System.out.println("Waiting for clients...");

            ServerSocket serverSocket = new ServerSocket(1234);

            Socket socket = serverSocket.accept();

            System.out.println("Connection established!");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            int number =  Integer.parseInt(in.readLine());

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println("Factorial of " + number+ " is: "+ calculateFactorial(number));





        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int calculateFactorial(int number){
        int fact = 1;
        for (int i = 1; i<= number; i++){
            fact = fact*i;
        }
        return fact;
    }
}
