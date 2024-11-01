package com.project;

 class Customer {
    private String policeNumber;
    private String brand;
    private String type;
    private String phoneNumber;
    private String complaint;
    private String mechanic;
    private String typeOfService;
    private double total;

    public Customer(String policeNumber, String brand, String type, String phoneNumber, String complaint, String mechanic, String typeOfService, double total){
        this.policeNumber = policeNumber;
        this.brand = brand;
        this.type = type;
        this.phoneNumber = phoneNumber;
        this.complaint = complaint;
        this.mechanic = mechanic;
        this.typeOfService = typeOfService;
        this.total = total;
    }

    public String getPoliceNumber(){
        return policeNumber;
    }

    public String getBrand(){
        return brand;
    }

    public String getType(){
        return type;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public String getComplaint(){
        return complaint;
    }

    public String getMechanic(){
        return mechanic;
    }

     public String getTypeOfService(){
         return typeOfService;
     }

     public double getTotal(){
         return total;
     }

}
