package com.company.design.factory.simplefactory;

import java.util.ArrayList;
import java.util.List;

public class NvWa {
    public static void main(String[] args) {
        Person whitePerson = SimpleFactory.getInstance(WhitePerson.class);
        whitePerson.talk();

        Person yellowPerson = SimpleFactory.getInstance("yellow");
        yellowPerson.talk();

        AbstractFactory factory = new HumanFactory();
        Person whitePerson1 = factory.getInstance(WhitePerson.class);
        whitePerson1.talk();

        List list = new ArrayList();
        list.listIterator();
    }
}