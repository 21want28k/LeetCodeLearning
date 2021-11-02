package com.company.design.singleton;

/**
 * 有问题的懒汉
 */
public class Singleton2 {
    public static Singleton2 object = null;

    private Singleton2() {

    }

    public static Singleton2 getInstance() {
        if (object == null) {
            object = new Singleton2();
        }
        return object;
    }
}