package com.company.design.factory.simplefactory;

public class WhitePerson implements Person {
    @Override
    public void getColor() {
        System.out.println("white person");
    }

    @Override
    public void talk() {
        System.out.println("white person talking");
    }
}
