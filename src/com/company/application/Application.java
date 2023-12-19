package com.company.application;

public class Application {

    private String nameClient;
    private long sum;
    private Operation typeOperation;

    public Application(String nameClient, long sum, Operation typeOperation ){
        this.nameClient = nameClient;
        this.sum = sum;
        this.typeOperation = typeOperation;
    }


    public String getNameClient() {
        return nameClient;
    }



    public long getSum() {
        return sum;
    }

    public Operation getTypeOperation() {
        return typeOperation;
    }


    @Override
    public String toString() {
        return "Application{" +
                "nameClient='" + nameClient + '\'' +
                ", sum=" + sum +
                ", typeOperation=" + typeOperation +
                '}';
    }



}
