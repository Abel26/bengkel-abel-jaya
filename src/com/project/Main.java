package com.project;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Login login = new Login();
    public static void main(String[] args) throws IOException {
        Scanner terminalInput = new Scanner(System.in);
        System.out.println("===== Jago Service POS =====");

        System.out.println("Selamat datang di Jago Service POS");

        System.out.print("Apakah anda ingin login (y/n) : ");
        String jawaban = terminalInput.nextLine();
        if(jawaban.equalsIgnoreCase("y")){
            login.login();
        }else if(jawaban.equalsIgnoreCase("n")){
            System.out.println("Anda Gagal Login");
        }else{
            System.out.println("Yang anda inputkan bukan y/n");
        }

    }
}
