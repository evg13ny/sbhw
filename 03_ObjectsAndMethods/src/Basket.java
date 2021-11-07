public class Basket {

    private static int count = 0;
    private String items = "";
    private int totalPrice = 0;
    private int limit;
    private double totalWeight = 0;
    private int defaultCount = 1;
    private int defaultWeight = 0;
    private String basketWeight = "";

    public static double totalCost; // общая стоимость
    public static int totalCount; // общее количество

    public Basket() {
        increaseCount(1);
        items = "Список товаров:";
        this.limit = 1000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice, double totalWeight) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
        this.totalWeight = totalWeight;
    }

    public static int getCount() {
        return count;
    }

    public static void increaseCount(int count) {
        Basket.count = Basket.count + count;
    }

    // увеличиваю общее количество
    public static void increaseTotalCount(int count) {
        Basket.totalCount = Basket.totalCount + count;
    }

    // увеличиваю общую стоимость
    public static void increaseTotalCost(int count, int price) {
        Basket.totalCost = Basket.totalCost + count * price;
    }

    // средняя цена товара
    public static double averageTotalPrice() {
        return totalCost / totalCount;
    }

    // средняя стоимость корзины
    public static double averagePrice() {
        return totalCost / count;
    }

    public void add(String name, int price) {
        add(name, price, defaultCount, defaultWeight);
    }

    public void add(String name, int price, int count) {
        add(name, price, count, defaultWeight);
    }

    public void add(String name, int price, double weight) {
        add(name, price, defaultCount, weight);
    }

    public void add(String name, int price, int count, double weight) {

        boolean error = false;

        if (contains(name)) {
            error = true;
        }

        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

        items = items + "\n" + name + " - " +
                count + " шт., цена - " + price +
                " руб., вес 1 шт. - " + weight + " кг";
        totalWeight = totalWeight + count * weight;
        basketWeight = "Общий вес: " + totalWeight + " кг";

        increaseTotalCount(count); // запоминаю количество товара в корзине
        increaseTotalCost(count, price); // запоминаю стоимость корзины
    }

    public void clear() {
        items = "";
        totalPrice = 0;
        totalWeight = 0;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {

        System.out.println(title);

        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items + "\n" + basketWeight + "\n");
        }
    }
}