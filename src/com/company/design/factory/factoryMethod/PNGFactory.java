package com.company.design.factory.factoryMethod;

public class PNGFactory extends AbstractReaderFactory {
    @Override
    public Reader getReader() {
        return new PNGReader();
    }
}