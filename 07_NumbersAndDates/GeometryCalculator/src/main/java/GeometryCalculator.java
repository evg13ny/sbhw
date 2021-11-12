public class GeometryCalculator {
    // метод должен использовать абсолютное значение radius
    public static double getCircleSquare(double radius) {
        if (radius != 0) {
            return Math.PI * Math.pow(Math.abs(radius), 2);
        }
        return 0;
    }

    // метод должен использовать абсолютное значение radius
    public static double getSphereVolume(double radius) {
        if (radius != 0) {
            return (4 * Math.PI * Math.pow(Math.abs(radius), 3)) / 3;
        }
        return 0;
    }

    public static boolean isTrianglePossible(double a, double b, double c) {
        return a + b > c && a + c > b && b + c > a;
    }

    // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
    // методом isTrianglePossible, если невозможен вернуть -1.0
    public static double getTriangleSquare(double a, double b, double c) {
        if (isTrianglePossible(a, b, c)) {
            double p = (a + b + c) / 2;
            return Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
        return -1.0;
    }
}
