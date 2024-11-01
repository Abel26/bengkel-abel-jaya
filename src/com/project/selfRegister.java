package com.project;

class selfRegister {
    private static String policeNumber;
    private static String brand;
    private static String type;
    private static String phoneNumber;
    private static String complaint;
    private static String mechanic;
    private static String typeOfService;

    public selfRegister(String policeNumber, String brand, String type, String phoneNumber, String complaint, String mechanic, String typeOfService){
        this.policeNumber = policeNumber;
        this.brand = brand;
        this.type = type;
        this.phoneNumber = phoneNumber;
        this.complaint = complaint;
        this.mechanic = mechanic;
        this.typeOfService = typeOfService;
    }

    public static String getPoliceNumber(){
        return policeNumber;
    }

    public static String getBrand(){
        return brand;
    }

    public static String getType(){
        return type;
    }

    public static String getPhoneNumber(){
        return phoneNumber;
    }

    public static String getComplaint(){
        return complaint;
    }

    public static String getMechanic(){
        return mechanic;
    }

    public static String getTypeOfService(){
        return typeOfService;
    }

}
