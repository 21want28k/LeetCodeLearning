package com.company.design.singleton;

/**
 * 静态内部类实现
 */
public class Singleton5 {

    private Singleton5() {

    }

    public Singleton5 getInstance() {
        return InstanceHolder.instance;
    }

    public static class InstanceHolder {
        private static final Singleton5 instance = new Singleton5();
    }
}