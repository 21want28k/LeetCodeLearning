package com.company.design.factory.abstractFactoryMethod;

public class AndroidFactory extends AbstractFactory{
    @Override
    public AbstractReader getReader() {
        return new AndroidReader();
    }

    @Override
    public AbstractWriter getWriter() {
        return null;
    }
}
