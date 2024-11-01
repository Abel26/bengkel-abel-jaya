package com.project;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class cashierDashboard {
    public void cashier() throws IOException {
        Scanner terminalInput = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("===== Menu =====");
            System.out.println("1. Data Pelanggan dan Motor");
            System.out.println("3. Keluar");

            System.out.print("Pilih menu (contoh: 1) : ");
            String jawaban = terminalInput.nextLine();

            switch (jawaban) {
                case "1":
                    dataPelanggan();
                    break;
                case "2":
                    // kelolaData();
                    break;
                case "3":
                    isRunning = false;  // Menghentikan loop untuk keluar
                    System.out.println("Terima kasih! Sampai jumpa.");
                    break;
                default:
                    System.out.println("Menu yang anda pilih tidak ada");
            }
        }
    }

    public void dataPelanggan() throws IOException {
        System.out.print("Input Nomor Polisi : ");
        String policeNumber = new Scanner(System.in).nextLine();
        searchPoliceNumber(policeNumber);
    }

    public void searchPoliceNumber(String policeNumberSearch) throws IOException {
        FileReader fileInput;
        BufferedReader bufferInput;

        boolean isFound = false;

        try {
            fileInput = new FileReader("databasePelanggan");
            bufferInput = new BufferedReader(fileInput);
        } catch (Exception e) {
            System.err.println("Database tidak ditemukan");
            return;
        }

        System.out.println("\n| Nomor Polisi |");
        System.out.println("------------------");

        String data = bufferInput.readLine();

        while (data != null) {
            StringTokenizer stringToken = new StringTokenizer(data, ",");

            String policeNumber = stringToken.nextToken();

            if (policeNumber.equals(policeNumberSearch)) {
                isFound = true;
                System.out.printf("| %2s | => Data Ditemukan\n", policeNumber);
                System.out.println("\nInput Data Service");
                addCustomer();
            }

            data = bufferInput.readLine();
        }
        bufferInput.close();

        if (!isFound) {
            System.out.println("Nomor Polisi tidak ditemukan. Menambah data baru...");
            addCustomer();
        }
    }

    public void addCustomer() throws IOException {
        Scanner terminalInput = new Scanner(System.in);

        String[][] montir = {
                {"Rudi", "Matic"},
                {"Abel", "Manual"},
                {"Mutia", "Kopling"}
        };

        System.out.print("Nomor Polisi : ");
        String policeNumber = terminalInput.nextLine();

        System.out.print("Merk Motor : ");
        String brand = terminalInput.nextLine();

        System.out.print("Tipe Motor : ");
        String type = terminalInput.nextLine();

        System.out.print("Nomor Telepon : ");
        String phoneNumber = terminalInput.nextLine();

        System.out.print("Keluhan : ");
        String complaint = terminalInput.nextLine();

        System.out.println("===== Daftar Montir =====");
        for (String[] mechanic : montir) {
            System.out.println(mechanic[0] + " => " + mechanic[1]);
        }

        System.out.print("Pilih Montir : ");
        String mechanic = terminalInput.nextLine();

        System.out.print("Jenis Service : ");
        String typeOfService = terminalInput.nextLine();

        // polymorphism
        Service service = new callService(typeOfService);

        System.out.print("Biaya Tambahan : ");
        double cost = terminalInput.nextDouble();

        service.jenisService();

        double total = cost + service.hitungBiaya();

        Customer customer = new Customer(policeNumber, brand, type, phoneNumber, complaint, mechanic, typeOfService, total);

        try (FileWriter fileWriter = new FileWriter("databasePelanggan", true);
             BufferedWriter bufferWriter = new BufferedWriter(fileWriter)) {
            bufferWriter.write(
                    customer.getPoliceNumber() + "," +
                            customer.getBrand() + "," +
                            customer.getType() + "," +
                            customer.getPhoneNumber() + "," +
                            customer.getComplaint() + "," +
                            customer.getMechanic() + "," +
                            customer.getTypeOfService() + "," +
                            customer.getTotal()
            );
            bufferWriter.newLine();
            bufferWriter.flush();
        }

        System.out.println("Data berhasil ditambahkan ke database.");
    }
}
