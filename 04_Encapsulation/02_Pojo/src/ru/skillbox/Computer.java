package ru.skillbox;

public class Computer {

    private double CPU;
    private short RAM;
    private short HDD;
    private String system;

    public Computer(double CPU, String system) {
        this.CPU = CPU;
        this.system = system;
    }

    public double getCPU() {
        return CPU;
    }

    public void setCPU(double CPU) {
        this.CPU = CPU;
    }

    public short getRAM() {
        return RAM;
    }

    public void setRAM(short RAM) {
        this.RAM = RAM;
    }

    public short getHDD() {
        return HDD;
    }

    public void setHDD(short HDD) {
        this.HDD = HDD;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }
}