package com.company.design.builder.traditional;

public class Bike {
    private String componentA;
    private String componentB;
    private String componentC;

    public Bike() {
    }


    public void setComponentA(String componentA) {
        this.componentA = componentA;
    }

    public void setComponentB(String componentB) {
        this.componentB = componentB;
    }

    public void setComponentC(String componentC) {
        this.componentC = componentC;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "componentA='" + componentA + '\'' +
                ", componentB='" + componentB + '\'' +
                ", componentC='" + componentC + '\'' +
                '}';
    }
}