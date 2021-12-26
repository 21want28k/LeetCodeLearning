package com.company.design.factory.factoryMethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client {
    public static void main(String[] args) {
        AbstractReaderFactory factory = new JPGFactory();
        Reader reader = factory.getReader();
        reader.readPicture();
        Logger logger = LoggerFactory.getLogger(Client.class);
    }
}