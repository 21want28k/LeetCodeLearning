package com.company.design.builder.traditional;

public abstract class Builder {
    protected abstract void buildComponentA();

    protected abstract void buildComponentB();

    protected abstract void buildComponentC();

    protected abstract Bike createBike();
}
