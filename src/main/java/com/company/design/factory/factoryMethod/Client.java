package com.company.design.factory.factoryMethod;

public class Client {
    public static void main(String[] args) {
        AbstractReaderFactory factory = new JPGFactory();
        Reader reader = factory.getReader();
        reader.readPicture();
//        Logger logger = LoggerFactory.getLogger(Client.class);
    }
}