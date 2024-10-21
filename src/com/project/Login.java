package com.project;

import java.io.IOException;
import java.util.Scanner;

public class Login {
    public void login() throws IOException {
        Scanner terminalInput = new Scanner(System.in);

        String[][] accounts = {
                {"kasirJago@gmail.com", "kasirJago123", "cashier"},
                {"adminJago@gmail.com", "kasirJago123", "admin"},
        };

        System.out.println("Halaman Login Jago Service POS");

        System.out.print("email : ");
        String email = terminalInput.nextLine();

        System.out.print("password : ");
        String password = terminalInput.nextLine();

        boolean loggedIn = false;
        String role = "";

        for(String[] account : accounts){
            if(account[0].equals(email) && account[1].equals(password)){
                loggedIn = true;
                role = account[2];
                break;
            }
        }

        if(loggedIn){
            System.out.println("Anda berhasil login sebagai " + role);
            if("cashier".equals(role)){
                cashierDashboard cashier = new cashierDashboard();
                cashier.cashier();
            } else if ("admin".equals(role)) {
                System.out.println("Admin");
            }
        }
    }
}
