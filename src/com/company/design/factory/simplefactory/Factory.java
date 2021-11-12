package com.company.design.factory.simplefactory;

public class Factory {

    public static Product getProduct(String productName) {
        Product product = null;
        switch (productName) {
            case "productA":
                product = new ProductA();
                break;
            case "productB":
                product = new ProductB();
                break;
        }
        return product;
    }
}
