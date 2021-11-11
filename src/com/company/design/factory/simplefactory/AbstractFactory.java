package com.company.design.factory.simplefactory;

public abstract class AbstractFactory {
    public abstract <T extends Person> T getInstance(Class<T> tClass);
}