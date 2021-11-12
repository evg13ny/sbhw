import java.util.Scanner;

public class Main {
    public static final int CONTAINERS_IN_TRUCK = 12;
    public static final int BOXES_IN_CONTAINER = 27;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String boxes = scanner.nextLine();

        // TODO: вывести в консоль коробки разложенные по грузовикам и контейнерам
        // пример вывода при вводе 2
        // для отступа используйте табуляцию - \t

        /*
        Грузовик: 1
            Контейнер: 1
                Ящик: 1
                Ящик: 2
        Необходимо:
        грузовиков - 1 шт.
        контейнеров - 1 шт.
        */

        int containers = 0;
        int trucks = 0;
        int cargo = Integer.parseInt(boxes.trim());

        for (int i = 1; i <= cargo; i++) {
            if (i % (CONTAINERS_IN_TRUCK * BOXES_IN_CONTAINER) == 1) {
                trucks++;
                System.out.println("Грузовик: " + trucks);
            }
            if (i % BOXES_IN_CONTAINER == 1) {
                containers++;
                System.out.println("\tКонтейнер: " + containers);
            }
            System.out.println("\t\tЯщик: " + i);
        }

        System.out.println("Необходимо:" + "\r\nгрузовиков - " + trucks + " шт." + "\r\nконтейнеров - " + containers + " шт.");
    }
}
