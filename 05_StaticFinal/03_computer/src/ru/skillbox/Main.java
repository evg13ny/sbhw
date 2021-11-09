package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        Computer computer1 = new Computer("Lenovo", "IdeaPad Gaming 3");
        computer1.setFrequency(3);
        computer1.setCores(6);
        computer1.setCpuVendor("AMD");
        computer1.setCpuWeight(.05);
        computer1.setRamType("DDR4");
        computer1.setRamVolume(8);
        computer1.setMemoryWeight(.2);
        computer1.setMemoryType(MemoryType.SSD);
        computer1.setMemoryVolume(512);
        computer1.setRamWeight(.6);
        computer1.setDiagonal(15.6);
        computer1.setDisplayType(DisplayType.IPS);
        computer1.setDisplayWeight(.3);
        computer1.setKeyboardType("Membrane");
        computer1.setBacklight(true);
        computer1.setKeyboardWeight(.15);

        Computer computer2 = new Computer("Huawei", "MateBook");
        computer2.setFrequency(1.6);
        computer2.setCores(4);
        computer2.setCpuVendor("Intel");
        computer2.setCpuWeight(.055);
        computer2.setRamType("DDR3");
        computer2.setRamVolume(6);
        computer2.setMemoryWeight(.215);
        computer2.setMemoryType(MemoryType.HDD);
        computer2.setMemoryVolume(256);
        computer2.setRamWeight(.725);
        computer2.setDiagonal(15);
        computer2.setDisplayType(DisplayType.TN);
        computer2.setDisplayWeight(.4);
        computer2.setKeyboardType("Mechanic");
        computer2.setBacklight(false);
        computer2.setKeyboardWeight(.1);

        System.out.println(computer1);
        System.out.println(computer2);
    }
}
