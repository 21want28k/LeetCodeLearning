package com.company.design.factory.abstractFactoryMethod;

public class IOSWriter extends AbstractWriter{
    @Override
    public void write() {
        System.out.println("IOS writer writing....");
    }
}
