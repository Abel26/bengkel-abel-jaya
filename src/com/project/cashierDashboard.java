package com.project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class cashierDashboard {
    public void cashier() throws IOException {
        Scanner terminalInput = new Scanner(System.in);
        System.out.println("===== Menu =====");

        System.out.println("1. Data Pelanggan dan Motor");
        System.out.println("2. Kelola Data Service");

        System.out.println("Pilih menu (contoh: 1)");
        String jawaban = terminalInput.nextLine();

        switch (jawaban){
            case "1":
                dataPelanggan();
                break;
            case "2":
//                kelolaData()
                break;
            default:
                System.out.println("Menu yang anda pilih tidak ada");
        }
    }

    public void dataPelanggan() throws IOException{
        FileReader fileInput;
        BufferedReader  bufferInput;

        try{
            fileInput = new FileReader("databasePelanggan");
            bufferInput = new BufferedReader(fileInput);
        }catch (Exception e){
            System.err.println("Database tidak ditemukan");
            return;
        }


        System.out.println("\n| Nomor Polisi |");
        System.out.println("------------------");

        String data = bufferInput.readLine();

        while(data != null){
            StringTokenizer stringToken = new StringTokenizer(data, ",");

            stringToken.nextToken();
            stringToken.nextToken();
            System.out.printf("|\t%2s", stringToken.nextToken());

            data = bufferInput.readLine();
        }

    }
}
