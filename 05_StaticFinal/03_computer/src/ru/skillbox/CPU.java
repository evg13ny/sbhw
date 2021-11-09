package ru.skillbox;

public class CPU {
    private double frequency;
    private int cores;
    private String cpuVendor;
    private double cpuWeight;

    public CPU(double frequency, int cores, String cpuVendor, double cpuWeight) {
        this.frequency = frequency;
        this.cores = cores;
        this.cpuVendor = cpuVendor;
        this.cpuWeight = cpuWeight;
    }

    public double getFrequency() {
        return frequency;
    }

    public int getCores() {
        return cores;
    }

    public String getCpuVendor() {
        return cpuVendor;
    }

    public double getCpuWeight() {
        return cpuWeight;
    }
}