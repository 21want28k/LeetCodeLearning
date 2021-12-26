package com.company.design.factory.factoryMethod;

public class PNGReader implements Reader {
    @Override
    public void readPicture() {
        System.out.println("PNGReader is reading");
    }
}
