package ru.skillbox;

public class RAM {
    private String ramType;
    private int ramVolume;
    private double ramWeight;

    public RAM(String ramType, int ramVolume, double ramWeight) {
        this.ramType = ramType;
        this.ramVolume = ramVolume;
        this.ramWeight = ramWeight;
    }

    public String getRamType() {
        return ramType;
    }

    public int getRamVolume() {
        return ramVolume;
    }

    public double getRamWeight() {
        return ramWeight;
    }
}
