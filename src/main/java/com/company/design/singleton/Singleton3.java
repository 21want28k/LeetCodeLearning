package com.company.design.singleton;

/**
 * 性能较差的懒汉
 */
public class Singleton3 {
    public static Singleton3 object = null;

    private Singleton3() {

    }

    public synchronized static Singleton3 getInstance() {
        if (object == null) {
            object = new Singleton3();
        }
        return object;
    }
}