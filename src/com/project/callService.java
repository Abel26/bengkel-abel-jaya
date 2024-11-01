package com.project;

public class callService extends Service{
    private double biaya;

    public callService(String jenisService) {
        super(jenisService);
    }

    @Override
    public void jenisService(){
        if (jenisService.equalsIgnoreCase("Service Besar")){
            biaya = 100000;

        }else if (jenisService.equalsIgnoreCase("Service Kecil")){
            biaya = 500000;
        } else if (jenisService.equalsIgnoreCase("Ganti Oli")) {
            biaya = 25000;
        }else {
//            biaya = 0;
        }
    }

    @Override
    public double hitungBiaya() {
        return biaya;
    }

    @Override
    public void tampilkanService() {
        System.out.println("Jenis Service : " + jenisService);
        System.out.println("Biaya : " + biaya);
    }
}
