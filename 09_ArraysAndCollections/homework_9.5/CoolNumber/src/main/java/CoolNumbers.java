import java.util.*;

public class CoolNumbers {
    static long startTime;
    static long endTime;

    public static List<String> generateCoolNumbers() {
        List<String> arrNum = new ArrayList<>();
        String[] carLetters = new String[]{"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};
        for (String xyz_1 : carLetters) {
            for (int n = 111; n <= 999; n += 111) {
                for (String xyz_2 : carLetters) {
                    for (String xyz_3 : carLetters) {
                        for (int r = 1; r <= 199; r++) {
                            String numberCar;
                            if (r < 10) {
                                numberCar = String.format("%s%d%s%s0%d", xyz_1, n, xyz_2, xyz_3, r);
                            } else {
                                numberCar = String.format("%s%d%s%s%d", xyz_1, n, xyz_2, xyz_3, r);
                            }
                            arrNum.add(numberCar);
                        }
                    }
                }
            }
        }
        return arrNum;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        startTime = System.nanoTime();
        if (list.contains(number)) {
            endTime = System.nanoTime();
            System.out.println("Поиск перебором: номер найден, поиск занял " + (endTime - startTime) + "нс");
            return true;
        } else {
            System.out.println("Поиск перебором: номер не найден");
            return false;
        }
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        startTime = System.nanoTime();
        Collections.sort(sortedList);
        int index = Collections.binarySearch(sortedList, number);
        if (index > -1) {
            endTime = System.nanoTime();
            System.out.println("Бинарный поиск: номер найден, поиск занял " + (endTime - startTime) + "нс");
            return true;
        } else {
            System.out.println("Бинарный поиск: номер не найден");
            return false;
        }
    }


    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        startTime = System.nanoTime();
        if (hashSet.contains(number)) {
            endTime = System.nanoTime();
            System.out.println("Поиск в HashSet: номер найден, поиск занял " + (endTime - startTime) + "нс");
            return true;
        } else {
            System.out.println("Поиск в HashSet: номер не найден");
            return false;
        }
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        startTime = System.nanoTime();
        if (treeSet.contains(number)) {
            endTime = System.nanoTime();
            System.out.println("Поиск в TreeSet: номер найден, поиск занял " + (endTime - startTime) + "нс");
            return true;
        } else {
            System.out.println("Поиск в TreeSet: номер не найден");
            return false;
        }
    }
}
