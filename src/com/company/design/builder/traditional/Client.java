package com.company.design.builder.traditional;

public class Client {
    public static void main(String[] args) {
        Director director = new Director();
        Bike haloBike = director.getHaloBike();
        Bike ofOBike = director.getOfOBike();
        System.out.println(haloBike);
        System.out.println(ofOBike);
    }
}
