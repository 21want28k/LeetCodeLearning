package com.company.design.factory.abstractFactoryMethod;

public abstract class AbstractFactory {
    public abstract AbstractReader getReader();

    public abstract AbstractWriter getWriter();
}