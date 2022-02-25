package com.company.design.factory.abstractFactoryMethod;

public class Client {
    public static void main(String[] args) {
        AbstractFactory factory = new IOSFactory();
        AbstractReader IOSReader = factory.getReader();
        AbstractWriter IOSWriter = factory.getWriter();
        IOSReader.reader();
        IOSWriter.write();
    }
}