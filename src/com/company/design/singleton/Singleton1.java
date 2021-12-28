package com.company.design.singleton;

/**
 * 饿汉
 */
public class Singleton1 {
    public static final Singleton1 object = new Singleton1();

    private Singleton1() {

    }

    public static Singleton1 getInstance() {
        return object;
    }

    public void doSomething() {
        System.out.println("do something");
    }
}