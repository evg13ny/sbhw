import java.util.*;

public class Main {
    /*
    TODO:
     - реализовать методы класса CoolNumbers
     - посчитать время поиска введимого номера в консоль в каждой из структуры данных
     - проанализоровать полученные данные
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> testArray = CoolNumbers.generateCoolNumbers();
        HashSet<String> testHashSet = new HashSet<>(testArray);
        TreeSet<String> testTreeSet = new TreeSet<>(testArray);

        while (true) {
            System.out.println("Введите «красивый» автомобильный номер:");
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }

            CoolNumbers.bruteForceSearchInList(testArray, input);
            CoolNumbers.binarySearchInList(testArray, input);
            CoolNumbers.searchInHashSet(testHashSet, input);
            CoolNumbers.searchInTreeSet(testTreeSet, input);
        }
    }
}
