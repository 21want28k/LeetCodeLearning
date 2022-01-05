package com.company.design.factory.abstractFactoryMethod;

public class IOSFactory extends AbstractFactory {
    @Override
    public AbstractReader getReader() {
        return new IOSReader();
    }

    @Override
    public AbstractWriter getWriter() {
        return new IOSWriter();
    }
}
