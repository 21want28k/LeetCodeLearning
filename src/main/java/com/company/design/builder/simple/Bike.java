package com.company.design.builder.simple;

public class Bike {
    private String componentA;
    private String componentB;
    private String componentC;

    private Bike(Builder builder) {
        this.componentA = builder.componentA;
        this.componentB = builder.componentB;
        this.componentC = builder.componentC;
    }


    public static final class Builder {
        private String componentA;
        private String componentB;
        private String componentC;

        public Builder() {
        }

        public Builder setComponentA(String componentA) {
            this.componentA = componentA;
            return this;
        }

        public Builder setComponentB(String componentB) {
            this.componentB = componentB;
            return this;
        }

        public Builder setComponentC(String componentC) {
            this.componentC = componentC;
            return this;
        }

        public Bike build() {
            return new Bike(this);
        }
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
