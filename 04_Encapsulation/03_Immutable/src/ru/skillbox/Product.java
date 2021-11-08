package ru.skillbox;

public class Product {
    private final String name;
    private int price;
    private final String barcode;

    public Product(String name, String barcode) {
        this.name = name;
        this.barcode = barcode;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getBarcode() {
        return barcode;
    }
}
