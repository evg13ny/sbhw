package ru.skillbox;

public class ArithmeticCalculator {
    private int x;
    private int y;

    public ArithmeticCalculator(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void calc(Operation operation) {
        switch (operation) {
            case ADD:
                System.out.println(x + " " + operation + " " + y + " = " + (x + y));
                break;
            case SUBTRACT:
                System.out.println(x + " " + operation + " " + y + " = " + (x - y));
                break;
            case MULTIPLY:
                System.out.println(x + " " + operation + " " + y + " = " + (x * y));
                break;
            default:
                break;
        }
    }
}
