package ru.skillbox;

public class Display {
    private double diagonal;
    private DisplayType displayType;
    private double displayWeight;

    public Display(double diagonal, DisplayType displayType, double displayWeight) {
        this.diagonal = diagonal;
        this.displayType = displayType;
        this.displayWeight = displayWeight;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public DisplayType getDisplayType() {
        return displayType;
    }

    public double getDisplayWeight() {
        return displayWeight;
    }
}
