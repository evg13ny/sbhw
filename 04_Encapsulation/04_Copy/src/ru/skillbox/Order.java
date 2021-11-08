package ru.skillbox;

public class Order {
    private final Dimensions dimensions;
    private final double weight;
    private final String address;
    private final boolean upDown;
    private final String regNumber;
    private final boolean breakable;

    public Order(Dimensions dimensions, double weight, String address, boolean upDown, String regNumber, boolean breakable) {
        this.dimensions = dimensions;
        this.weight = weight;
        this.address = address;
        this.upDown = upDown;
        this.regNumber = regNumber;
        this.breakable = breakable;
    }

    public Order setAddress(String address) {
        return new Order(dimensions, weight, address, upDown, regNumber, breakable);
    }

    public Order setWeight(double weight) {
        return new Order(dimensions, weight, address, upDown, regNumber, breakable);
    }

    public Order setDimensions(Dimensions dimensions) {
        return new Order(dimensions, weight, address, upDown, regNumber, breakable);
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public double getWeight() {
        return weight;
    }

    public String getAddress() {
        return address;
    }

    public boolean isUpDown() {
        return upDown;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public boolean isBreakable() {
        return breakable;
    }

    public String toString() {
        return dimensions +
                "масса: " + weight + " кг" + "\n" +
                "адрес доставки: " + address + "\n" +
                "соблюдать стороны: " + upDown + "\n" +
                "регистрационный номер: " + regNumber + "\n" +
                "хрупкое: " + breakable + "\n";
    }
}
