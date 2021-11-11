package com.company.design.factory.simplefactory;

public class SimpleFactory {

    public static <T extends Person> T getInstance(Class<T> tClass) {
        Person person = null;

        try {
            person = (Person) Class.forName(tClass.getName()).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            System.out.println("Fail to create");
        }
        return (T) person;
    }

    public static Person getInstance(String personName) {
        Person p = null;
        switch (personName) {
            case "white":
                p = new WhitePerson();
                break;
            case "yellow":
                p = new YellowPerson();
                break;
        }
        return p;
    }
}