package com.company.design.factory.simplefactory;

public class YellowPerson implements Person {
    @Override
    public void getColor() {
        System.out.println("Yellow Person");
    }

    @Override
    public void talk() {
        System.out.println("Yellow Person talking");
    }
}
