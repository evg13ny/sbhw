public class Main {

    public static void main(String[] args) {

        /** задание 1 **/

        System.out.println("Задание 1");
        Basket vasyaBasket = new Basket();
        vasyaBasket.add("Молоко", 80);
        vasyaBasket.add("Хлеб", 40, 0.7);
        vasyaBasket.add("Шоколадка", 90, 3);
        vasyaBasket.add("Масло", 140, 2, 0.180);

        Basket petyaBasket = new Basket(500);
        petyaBasket.add("Лопата", 200, 1.0);
        petyaBasket.add("Бочка", 2900);
        petyaBasket.add("Гвозди", 10, 0.9);
        petyaBasket.add("Ведро", 50, 2);
        petyaBasket.add("Молоток", 70, 3, 0.5);

        Basket mashaBasket = new Basket(1000);
        mashaBasket.add("Творог",140,2,.2);
        mashaBasket.add("Сметана", 70, 1,.315);
        mashaBasket.add("Печенье",40,3,.120);
        mashaBasket.add("Минералка",40,6,1.25);

        vasyaBasket.print("Корзина Васи: ");
        petyaBasket.print("Корзина Пети: ");
        mashaBasket.print("Корзина Маши: ");

        /** задание 5.1 **/

        System.out.println("Задание 5.1");
        System.out.println("Средняя цена товара во всех корзинах: " + Basket.averageTotalPrice() + " руб.");
        System.out.println("Средняя стоимость корзины: " + Basket.averagePrice() + " руб.");

        /** задание 2 **/

        // System.out.println("Задание 2");
        // Arithmetic newArithmetic = new Arithmetic(2976, 318);
        // newArithmetic.result();

        // Arithmetic anotherNewArithmetic = new Arithmetic(7496, 51);
        // anotherNewArithmetic.result();

        /** задание 3 **/

        // System.out.println("Задание 3");
        // Printer printer = new Printer();
        // printer.print();
        // printer.append("hello world", 5);
        // printer.append("hello world");
        // printer.append("hello world", "hello");
        // printer.append("hello world", "world", 10);
        // printer.append("hello world", 2);
        // printer.append("hello world", 5);
        // printer.print();
        // printer.append("hello world");
        // printer.append("hello world", "hello", 10);
        // printer.getPendingPagesCount();
        // printer.clear();
        // printer.append("hello world", "world", 10);
        // printer.append("hello world", 2);
        // printer.print();
        // printer.getPendingPagesCount();
        // printer.totalPages();
    }
}