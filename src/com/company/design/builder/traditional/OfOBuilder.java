package com.company.design.builder.traditional;

public class OfOBuilder extends Builder {
    private Bike ofoBike = new Bike();

    @Override
    protected void buildComponentA() {
        this.ofoBike.setComponentA("ofo componentA");
    }

    @Override
    protected void buildComponentB() {
        this.ofoBike.setComponentB("ofo componentB");
    }

    @Override
    protected void buildComponentC() {
        this.ofoBike.setComponentC("ofo componentC");
    }

    @Override
    protected Bike createBike() {
        return this.ofoBike;
    }
}
