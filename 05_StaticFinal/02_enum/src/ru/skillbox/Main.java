package ru.skillbox;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("Введите первое число: ");
        int x = new Scanner(System.in).nextInt();
        System.out.print("Введите второе число: ");
        int y = new Scanner(System.in).nextInt();

        ArithmeticCalculator calculator = new ArithmeticCalculator(x, y);
        calculator.calc(Operation.ADD);
        calculator.calc(Operation.SUBTRACT);
        calculator.calc(Operation.MULTIPLY);
    }
}
