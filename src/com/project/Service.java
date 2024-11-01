package com.project;

import java.io.IOException;

abstract class Service {
    String jenisService;

    public Service(String jenisService) {
        this.jenisService = jenisService;
    }

    public abstract void jenisService();
    public abstract double hitungBiaya();
    public abstract  void tampilkanService();
}
