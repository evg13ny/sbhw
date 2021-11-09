package ru.skillbox;

public class Memory {
    private MemoryType memoryType;
    private int memoryVolume;
    private double memoryWeight;

    public Memory(MemoryType memoryType, int memoryVolume, double memoryWeight) {
        this.memoryType = memoryType;
        this.memoryVolume = memoryVolume;
        this.memoryWeight = memoryWeight;
    }

    public MemoryType getMemoryType() {
        return memoryType;
    }

    public int getMemoryVolume() {
        return memoryVolume;
    }

    public double getMemoryWeight() {
        return memoryWeight;
    }
}
