package com.company.design.factory.simplefactory;

public class HumanFactory extends AbstractFactory {
    @Override
    public <T extends Person> T getInstance(Class<T> tClass) {
        T person = null;
        try {
            person = tClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return person;
    }
}