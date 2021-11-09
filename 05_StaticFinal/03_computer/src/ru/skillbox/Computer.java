package ru.skillbox;

public class Computer {
    private final String computerVendor;
    private final String name;

    private double frequency;
    private int cores;
    private String cpuVendor;
    private double cpuWeight;

    private String ramType;
    private int ramVolume;
    private double ramWeight;

    private MemoryType memoryType;
    private int memoryVolume;
    private double memoryWeight;

    private double diagonal;
    private DisplayType displayType;
    private double displayWeight;

    private String keyboardType;
    private boolean backlight;
    private double keyboardWeight;

    private double weight;

    public Computer(String computerVendor, String name) {
        this.computerVendor = computerVendor;
        this.name = name;
    }

    public String getComputerVendor() {
        return computerVendor;
    }

    public String getName() {
        return name;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public int getCores() {
        return cores;
    }

    public void setCores(int cores) {
        this.cores = cores;
    }

    public String getCpuVendor() {
        return cpuVendor;
    }

    public void setCpuVendor(String cpuVendor) {
        this.cpuVendor = cpuVendor;
    }

    public double getCpuWeight() {
        return cpuWeight;
    }

    public void setCpuWeight(double cpuWeight) {
        this.cpuWeight = cpuWeight;
        weight = weight + cpuWeight;
    }

    public String getRamType() {
        return ramType;
    }

    public void setRamType(String ramType) {
        this.ramType = ramType;
    }

    public int getRamVolume() {
        return ramVolume;
    }

    public void setRamVolume(int ramVolume) {
        this.ramVolume = ramVolume;
    }

    public double getRamWeight() {
        return ramWeight;
    }

    public void setRamWeight(double ramWeight) {
        this.ramWeight = ramWeight;
        weight = weight + ramWeight;
    }

    public MemoryType getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(MemoryType memoryType) {
        this.memoryType = memoryType;
    }

    public int getMemoryVolume() {
        return memoryVolume;
    }

    public void setMemoryVolume(int memoryVolume) {
        this.memoryVolume = memoryVolume;
    }

    public double getMemoryWeight() {
        return memoryWeight;
    }

    public void setMemoryWeight(double memoryWeight) {
        this.memoryWeight = memoryWeight;
        weight = weight + memoryWeight;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(double diagonal) {
        this.diagonal = diagonal;
    }

    public DisplayType getDisplayType() {
        return displayType;
    }

    public void setDisplayType(DisplayType displayType) {
        this.displayType = displayType;
    }

    public double getDisplayWeight() {
        return displayWeight;
    }

    public void setDisplayWeight(double displayWeight) {
        this.displayWeight = displayWeight;
        weight = weight + displayWeight;
    }

    public String getKeyboardType() {
        return keyboardType;
    }

    public void setKeyboardType(String keyboardType) {
        this.keyboardType = keyboardType;
    }

    public boolean isBacklight() {
        return backlight;
    }

    public void setBacklight(boolean backlight) {
        this.backlight = backlight;
    }

    public double getKeyboardWeight() {
        return keyboardWeight;
    }

    public void setKeyboardWeight(double keyboardWeight) {
        this.keyboardWeight = keyboardWeight;
        weight = weight + keyboardWeight;
    }

    public String toString() {
        return "\n" + getComputerVendor() + " " + getName() +
                "\nПроцессор:" +
                "\nЧастота - " + getFrequency() + " GHz" + ";" +
                "\nКоличество ядер - " + getCores() + ";" +
                "\nПроизводитель - " + getCpuVendor() + ";" +
                "\nВес - " + getCpuWeight() + " кг" + ";" +
                "\nОперативная память:" +
                "\nТип - " + getRamType() + ";" +
                "\nОбъём - " + getRamVolume() + " Gb" + ";" +
                "\nВес - " + getRamWeight() + " кг" + ";" +
                "\nНакопитель информации:" +
                "\nТип - " + getMemoryType() + ";" +
                "\nОбъём памяти - " + getMemoryVolume() + " Gb" + ";" +
                "\nВес - " + getMemoryWeight() + " кг" + ";" +
                "\nЭкран:" +
                "\nДиагональ - " + getDiagonal() + "'" + ";" +
                "\nТип - " + getDisplayType() + ";" +
                "\nВес - " + getDisplayWeight() + " кг" + ";" +
                "\nКлавиатура:" +
                "\nТип - " + getKeyboardType() + ";" +
                "\nНаличие подсветки - " + isBacklight() + ";" +
                "\nВес - " + getKeyboardWeight() + " кг" + ";" +
                "\nОбщая масса - " + weight + " кг";
    }
}
