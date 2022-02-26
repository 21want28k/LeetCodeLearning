package com.company.design.builder.simple;

public class Client {
    public static void main(String[] args) {
        Bike bike = new Bike.Builder()
                .setComponentA("componentA")
                .setComponentB("componentB")
                .setComponentC("componentC")
                .build();
        System.out.println(bike.toString());
    }
}
