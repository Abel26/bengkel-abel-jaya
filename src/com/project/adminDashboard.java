package com.project;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class adminDashboard {
    public void admin() throws IOException {
        Scanner terminalInput = new Scanner(System.in);

        boolean repat = false;

            System.out.println("Database Pelanggan\n");
            System.out.println("1. \tLihat Seluruh Data Pelanggan");
            System.out.println("2. \tCari Data Pelanggan");
            System.out.println("3. \tTambah Data Pelanggan");
            System.out.println("4.\tHapus Data Pelanggan");

            System.out.print("Pilih menu [1-4] : ");
            String jawaban = terminalInput.nextLine();

            switch (jawaban){
                case "1" :
                    System.out.println("\n=================");
                    System.out.println("LIST SELURUH DATA PELANGGAN");
                    System.out.println("=================");
                    lihatSeluruhData();
                    break;
                case "2" :
                    System.out.println("\n=================");
                    System.out.println("CARI PELAMGGAN");
                    System.out.println("=================");
                    cariData();
                    break;
                case "3" :
                    System.out.println("\n=================");
                    System.out.println("TAMBAH DATA PELANGGAN");
                    System.out.println("=================");
                    tambahData();
                    break;
                case "4" :
                    System.out.println("\n=================");
                    System.out.println("HAPUS DATA PELANGGAN");
                    System.out.println("=================");
                    hapusData();
                    break;
                default:
                    System.err.print("\nInput anda tidak ditemukan\nSilahkan pilih [1-5] : ");
        }
    }

    public static void tambahData() throws IOException{
        String[][] montir = {
                {"Rudi", "Matic"},
                {"Abel", "Manual"},
                {"Mutia", "Kopling"}
        };

        FileWriter fileOutput = new FileWriter("databasePelanggan",true);
        BufferedWriter bufferOutput = new BufferedWriter(fileOutput);

        // mengambil input dari admin
        Scanner terminalInput = new Scanner(System.in);

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

        String keywords[] = {policeNumber + "," + brand + "," + type + "," + phoneNumber + "," + complaint + "," + mechanic + "," + typeOfService + "," + total};

        boolean isExist = cekPelangganDiDatabase(keywords,false);

        // menulis pelanggan di databse
        if (!isExist){
            System.out.println("\nData yang akan Anda masukan adalah");
            System.out.println("----------------------------------------");
            System.out.println("Nomor Polisi    : " + policeNumber);
            System.out.println("Merk Motor      : " + brand);
            System.out.println("Tipe Motor      : " + type);
            System.out.println("Nomor Telepon   : " + phoneNumber);
            System.out.println("Keluhan         : " + complaint);
            System.out.println("Montir          : " + mechanic);
            System.out.println("Jenis Service   : " + typeOfService);
            System.out.println("Biaya Total  : " + total);

            boolean isTambah = getYesOrNo("Apakah akan ingin menambah data tersebut? ");

            if(isTambah){
                bufferOutput.write(policeNumber + "," + brand + "," + type + "," + phoneNumber + "," + complaint + "," + mechanic + "," + typeOfService + "," + total);
                bufferOutput.newLine();
                bufferOutput.flush();
                System.out.println("Data berhasil ditambahkan");
            }

        }
        bufferOutput.close();
    }

    private static boolean cekPelangganDiDatabase(String keywords[], boolean isDisplay) throws IOException{
        FileReader fileInput = new FileReader("databasePelanggan");
        BufferedReader bufferInput = new BufferedReader(fileInput);

        String data = bufferInput.readLine();
        boolean isExist = false;
        int nomorData = 0;

        if (isDisplay) {
            System.out.println("\n| No |\tNomor Polisi |\tMerk Motor                |\tTipe Motor               |\tNomor Telepon    |\tKeluhan      |\tMontir    |\t Jenis Service     |\tTotal Biaya");
            System.out.println("----------------------------------------------------------------------------------------------------------");
        }

        while(data != null){
            isExist = true;

            for(String keyword:keywords){
                isExist = isExist && data.toLowerCase().contains(keyword.toLowerCase());
            }

            if(isExist){
                if(isDisplay) {
                    nomorData++;
                    StringTokenizer stringToken = new StringTokenizer(data, ",");

                    System.out.printf("| %2d ", nomorData);
                    System.out.printf("|\t%4s  ", stringToken.nextToken());
                    System.out.printf("|\t%-20s   ", stringToken.nextToken());
                    System.out.printf("|\t%-20s   ", stringToken.nextToken());
                    System.out.printf("|\t%-20s   ", stringToken.nextToken());
                    System.out.printf("|\t%-20s  ", stringToken.nextToken());
                    System.out.printf("|\t%-20s   ", stringToken.nextToken());
                    System.out.printf("|\t%-20s   ", stringToken.nextToken());
                    System.out.printf("|\t%s   ", stringToken.nextToken());
                    System.out.print("\n");
                } else {
                    break;
                }
            }

            data = bufferInput.readLine();
        }
        if (isDisplay){
            System.out.println("----------------------------------------------------------------------------------------------------------");
        }

        return isExist;
    }

    private static boolean getYesOrNo(String message){
        Scanner terminalInput = new Scanner(System.in);
        System.out.print("\n"+message+" (y/n)? ");
        String pilihanUser = terminalInput.next();

        while(!pilihanUser.equalsIgnoreCase("y") && !pilihanUser.equalsIgnoreCase("n")) {
            System.err.println("Pilihan anda bukan y atau n");
            System.out.print("\n"+message+" (y/n)? ");
            pilihanUser = terminalInput.next();
        }

        return pilihanUser.equalsIgnoreCase("y");

    }

    public static void lihatSeluruhData() throws IOException {
        System.out.println("\n=================");
        System.out.println("LIST SELURUH DATA PELANGGAN");
        System.out.println("=================");

        FileReader fileInput = new FileReader("databasePelanggan");
        BufferedReader bufferInput = new BufferedReader(fileInput);

        String data = bufferInput.readLine();
        int nomorData = 0;

        System.out.printf("\n| %-3s | %-12s | %-15s | %-15s | %-15s | %-12s | %-10s | %-15s | %-12s |\n",
                "No", "Nomor Polisi", "Merk Motor", "Tipe Motor", "Nomor Telepon", "Keluhan", "Montir", "Jenis Service", "Total Biaya");
        System.out.println("----------------------------------------------------------------------------------------------------------");

        while(data != null) {
            nomorData++;
            StringTokenizer stringToken = new StringTokenizer(data, ",");

            System.out.printf("| %2d ", nomorData);
            System.out.printf("|\t%4s  ", stringToken.nextToken());
            System.out.printf("|\t%-20s   ", stringToken.nextToken());
            System.out.printf("|\t%-20s   ", stringToken.nextToken());
            System.out.printf("|\t%-20s   ", stringToken.nextToken());
            System.out.printf("|\t%-20s  ", stringToken.nextToken());
            System.out.printf("|\t%-20s   ", stringToken.nextToken());
            System.out.printf("|\t%-20s   ", stringToken.nextToken());
            System.out.printf("|\t%s   ", stringToken.nextToken());
            System.out.print("\n");

            data = bufferInput.readLine();
        }

        System.out.println("----------------------------------------------------------------------------------------------------------");
        bufferInput.close();
    }

    // Fungsi untuk mencari data pelanggan
    public static void cariData() throws IOException {
        Scanner terminalInput = new Scanner(System.in);
        System.out.print("Masukkan kata kunci untuk mencari data pelanggan: ");
        String keyword = terminalInput.nextLine();
        String[] keywords = keyword.split("\\s+");

        cekPelangganDiDatabase(keywords, true);
    }

    // Fungsi untuk menghapus data pelanggan
    public static void hapusData() throws IOException {
        File database = new File("databasePelanggan");
        File tempDB = new File("tempDB");

        FileReader fileInput = new FileReader(database);
        BufferedReader bufferInput = new BufferedReader(fileInput);

        FileWriter fileOutput = new FileWriter(tempDB);
        BufferedWriter bufferOutput = new BufferedWriter(fileOutput);

        // Menampilkan data yang ada
        System.out.println("\n=================");
        System.out.println("HAPUS DATA PELANGGAN");
        System.out.println("=================");
        lihatSeluruhData();

        // Mengambil data yang ingin dihapus
        Scanner terminalInput = new Scanner(System.in);
        System.out.print("\nMasukkan nomor data yang ingin dihapus: ");
        int deleteNum = terminalInput.nextInt();

        // Looping dan hapus data yang sesuai
        String data = bufferInput.readLine();
        int entryCount = 0;
        boolean isFound = false;

        while(data != null) {
            entryCount++;
            boolean isDelete = false;

            // Menghapus data sesuai nomor yang diinputkan
            if (deleteNum == entryCount) {
                isDelete = true;
                isFound = true;
            }

            if (!isDelete) {
                bufferOutput.write(data);
                bufferOutput.newLine();
            } else {
                System.out.println("\nData berhasil dihapus!");
            }

            data = bufferInput.readLine();
        }

        if (!isFound) {
            System.err.println("Data tidak ditemukan!");
        }

        // Menutup dan menghapus file lama
        bufferOutput.flush();
        bufferOutput.close();
        fileOutput.close();
        bufferInput.close();
        fileInput.close();

        System.gc();
        database.delete();
        tempDB.renameTo(database);
    }
}
