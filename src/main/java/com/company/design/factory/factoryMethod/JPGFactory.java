package com.company.design.factory.factoryMethod;

public class JPGFactory extends AbstractReaderFactory {
    @Override
    public Reader getReader() {
        return new JPGReader();
    }
}
