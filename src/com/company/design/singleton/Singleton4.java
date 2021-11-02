package com.company.design.singleton;

/**
 * DCL(double check lock)
 */
public class Singleton4 {
    public static Singleton4 object = null;

    private Singleton4() {

    }

    public static Singleton4 getInstance() {
        if (object == null) {
            synchronized (Singleton4.class) {
                if (object == null) {
                    object = new Singleton4();
                }
            }
        }
        return object;
    }
}