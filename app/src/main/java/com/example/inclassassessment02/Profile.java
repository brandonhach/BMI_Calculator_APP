package com.example.inclassassessment02;

import java.io.Serializable;

public class Profile implements Serializable {
    double height, weight, bmi;
    public Profile(double height, double weight, double bmi) {
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
    }

    public Profile(){}

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
