package com.company.design.builder.traditional;

public class Director {
    private Builder haloBikeBuilder = new HaloBuilder();
    private Builder OfOBikeBuilder = new OfOBuilder();

    public Bike getHaloBike() {
        this.haloBikeBuilder.buildComponentA();
        this.haloBikeBuilder.buildComponentB();
        return haloBikeBuilder.createBike();
    }

    public Bike getOfOBike() {
        this.OfOBikeBuilder.buildComponentA();
        this.OfOBikeBuilder.buildComponentC();
        return OfOBikeBuilder.createBike();
    }

    public Bike geHaloBike() {
        return haloBikeBuilder.createBike();
    }
}
