package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        Dimensions details1 = new Dimensions(.5, .7, .9);
        Order order1 = new Order(
                details1,
                10,
                "00000 LA Sunset Blvd. 1 - 5",
                true,
                "A-02003",
                true);
        System.out.println("Заказ 1: " + "\n" + order1);

        Dimensions details2 = new Dimensions(.1, .3, .4);
        Order order2 = new Order(
                details2,
                5,
                "11111 NYC Sunrise Blvd. 21 - 57",
                false,
                "B-23789",
                true);
        System.out.println("Заказ 2: " + "\n" + order2);


        details1 = details1.setLength(2);
        order1 = order1.setWeight(17.9).setDimensions(details1);
        System.out.println("Заказ 1 обновлённый: " + "\n" + order1);

        details2 = details2.setWidth(1.3).setHeight(.7);
        order2 = order2.setAddress("99852 Boston Flower Blvd. 85 - 136").setDimensions(details2);
        System.out.println("Заказ 2 обновлённый: " + "\n" + order2);
    }
}
