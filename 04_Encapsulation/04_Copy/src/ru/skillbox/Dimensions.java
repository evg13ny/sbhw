package ru.skillbox;

public class Dimensions {
    private final double length;
    private final double width;
    private final double height;

    public Dimensions(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public Dimensions setLength(double length) {
        return new Dimensions(length, width, height);
    }

    public double getWidth() {
        return width;
    }

    public Dimensions setWidth(double width) {
        return new Dimensions(length, width, height);
    }

    public double getHeight() {
        return height;
    }

    public Dimensions setHeight(double height) {
        return new Dimensions(length, width, height);
    }

    public double size() {
        return length * width * height;
    }

    public String toString() {
        return "длина: " + length + " м" + "\n" +
                "ширина: " + width + " м" + "\n" +
                "высота: " + height + " м" + "\n" +
                "объём груза: " + size() + " м3" + "\n";
    }
}
