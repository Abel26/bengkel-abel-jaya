package com.project;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Login login = new Login();
    static adminDashboard admin = new adminDashboard();
    static cashierDashboard cashier = new cashierDashboard();
    static guestDashboard guest = new guestDashboard();
    static customerDashboard customer = new customerDashboard();

    public static void main(String[] args) throws IOException {
        Scanner terminalInput = new Scanner(System.in);
        System.out.println("===== Jago Service POS =====");

        System.out.println("Selamat datang di Jago Service POS");

        boolean isRunning = true;

        while (isRunning){

        System.out.println("===== Menu =====");

        System.out.println("1. Menu Tamu");
        System.out.println("2. Menu Pelanggan");
        System.out.println("3. Menu Kasir");
        System.out.println("4. Menu Admin");

        System.out.print("Pilih Menu (contoh: 1) : ");
        String jawaban = terminalInput.nextLine();
        switch (jawaban){
            case "1" :
                guest.guest();
                break;
            case "2" :
                customer.customer();
                break;
            case "3" :
                login.login();
                break;
            case "4" :
                login.login();
            }
        }

    }
}
