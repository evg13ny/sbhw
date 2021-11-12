import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Введите радиус круга, м: ");
        double x = new Scanner(System.in).nextDouble();
        System.out.print("Введите радиус шара, м: ");
        double r = new Scanner(System.in).nextDouble();
        System.out.print("Введите длину первой стороны треугольника, м: ");
        double a = new Scanner(System.in).nextDouble();
        System.out.print("Введите длину второй стороны треугольника, м: ");
        double b = new Scanner(System.in).nextDouble();
        System.out.print("Введите длину третьей стороны треугольника, м: ");
        double c = new Scanner(System.in).nextDouble();

        System.out.println("====================");
        System.out.println("Площадь круга - " + GeometryCalculator.getCircleSquare(x) + " м2");
        System.out.println("Объём шара - " + GeometryCalculator.getSphereVolume(r) + " м3");
        System.out.println("Площадь треугольника - " + GeometryCalculator.getTriangleSquare(a, b, c) + " м2");
    }
}
