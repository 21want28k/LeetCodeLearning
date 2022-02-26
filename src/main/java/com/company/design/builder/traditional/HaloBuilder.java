package com.company.design.builder.traditional;

public class HaloBuilder extends Builder {
    private Bike haloBike = new Bike();

    @Override
    protected void buildComponentA() {
        this.haloBike.setComponentA("halo componentA");
    }

    @Override
    protected void buildComponentB() {
        this.haloBike.setComponentB("halo componentB");
    }

    @Override
    protected void buildComponentC() {
        this.haloBike.setComponentC("halo componentC");
    }

    @Override
    protected Bike createBike() {
        this.haloBike.setComponentA("halo componentA");
        this.haloBike.setComponentB("halo componentB");
        return this.haloBike;
    }
}