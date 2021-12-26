package com.company.design.factory.factoryMethod;

public class JPGReader implements Reader{
    @Override
    public void readPicture() {
        System.out.println("JPGReader is reading");
    }
}