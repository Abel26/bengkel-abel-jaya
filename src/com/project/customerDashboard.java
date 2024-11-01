package com.project;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class customerDashboard {
    public void customer() throws IOException {
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

        selfRegister self = new selfRegister(policeNumber, brand, type, phoneNumber, complaint, mechanic, typeOfService);

        try (FileWriter fileWriter = new FileWriter("selfRegisterDatabase", true);
             BufferedWriter bufferWriter = new BufferedWriter(fileWriter)) {
            bufferWriter.write(
                    selfRegister.getPoliceNumber() + "," +
                            selfRegister.getBrand() + "," +
                            selfRegister.getType() + "," +
                            selfRegister.getPhoneNumber() + "," +
                            selfRegister.getComplaint() + "," +
                            selfRegister.getMechanic() + "," +
                            selfRegister.getTypeOfService()
            );
            bufferWriter.newLine();
            bufferWriter.flush();
        }

        System.out.println("Data berhasil ditambahkan ke database.");
    }
}
