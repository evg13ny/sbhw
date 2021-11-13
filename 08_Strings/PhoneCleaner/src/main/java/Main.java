import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            //TODO:напишите ваш код тут, результат вывести в консоль.

            String regex = "[^\\d]";
            String numbers = input.replaceAll(regex, "");
            String regexPhoneNumber = "[7|8]?[\\d]{10}";
            boolean isPhoneNumber = numbers.matches(regexPhoneNumber);

            if (!isPhoneNumber) {
                System.out.println("Неверный формат номера");
            } else if (numbers.length() == 10) {
                System.out.println("7" + numbers);
            } else if (numbers.startsWith("8")) {
                StringBuilder newPhone = new StringBuilder(numbers);
                newPhone.setCharAt(0, '7');
                System.out.println(newPhone);
            } else {
                System.out.println(numbers);
            }
        }
    }
}