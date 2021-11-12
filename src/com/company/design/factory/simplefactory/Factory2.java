package com.company.design.factory.simplefactory;

public class Factory2 {

    public static <T extends Product> T getProduct(Class<T> tClass) {
        T product = null;
        try {
            product = tClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }
}
