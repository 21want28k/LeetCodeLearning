package com.company.design.factory.simplefactory;

public class Client {
    public static void main(String[] args) {
        Product productA = Factory.getProduct("productA");
        productA.doSomething();
        Product productB = Factory.getProduct("productB");
        productB.doSomething();

        ProductA productA1 = Factory2.getProduct(ProductA.class);
        productA1.doSomething();
    }
}
