package com.project;

public class guestDashboard {
    public void guest() {
        // Data tabel
        String[] typeService = {
                "Jasa Service Besar", "Jasa Service Sedang", "Jasa Service Kecil",
                "Jasa Ganti Oli", "Busi", "Oli Mesin Matic 0,8 L", "Oli Gardan Matic",
                "Oli Mesin 0,8 L", "Oli Mesin 1L", "Ban Tubeless r14", "Ban Tubeless r17"
        };
        int[] biaya = {
                100000, 50000, 25000, 5000, 25000, 55000, 25000, 45000, 60000, 350000, 400000
        };

        // Judul kolom
        String col1 = "Type Service";
        String col2 = "Biaya";

        // Lebar kolom
        int col1Width = 20;
        int col2Width = 12;

        // Garis atas
        System.out.println("+"+"-".repeat(col1Width)+"+"+"-".repeat(col2Width)+"+");

        // Judul kolom
        System.out.printf("| %-"+col1Width+"s | %-"+col2Width+"s |\n", col1, col2);

        // Garis tengah
        System.out.println("+"+"-".repeat(col1Width)+"+"+"-".repeat(col2Width)+"+");

        // Isi tabel
        for (int i = 0; i < typeService.length; i++) {
            System.out.printf("| %-"+col1Width+"s | %"+col2Width+"d |\n", typeService[i], biaya[i]);
        }

        // Garis bawah
        System.out.println("+"+"-".repeat(col1Width)+"+"+"-".repeat(col2Width)+"+");
    }
}
