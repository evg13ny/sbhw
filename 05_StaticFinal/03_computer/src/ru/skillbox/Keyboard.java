package ru.skillbox;

public class Keyboard {
    private String keyboardType;
    private boolean backlight;
    private double keyboardWeight;

    public Keyboard(String keyboardType, boolean backlight, double keyboardWeight) {
        this.keyboardType = keyboardType;
        this.backlight = backlight;
        this.keyboardWeight = keyboardWeight;
    }

    public String getKeyboardType() {
        return keyboardType;
    }

    public boolean isBacklight() {
        return backlight;
    }

    public double getKeyboardWeight() {
        return keyboardWeight;
    }
}
