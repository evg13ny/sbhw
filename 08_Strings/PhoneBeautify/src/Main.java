import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }

            String regex = "[^\\d]";
            String numbers = input.replaceAll(regex, "");
            String regexPhoneNumber = "(7|8)?(\\d{3})(\\d{3})(\\d{2})(\\d{2})";
            boolean isPhoneNumber = numbers.matches(regexPhoneNumber);
            Pattern pattern = Pattern.compile(regexPhoneNumber);
            Matcher matcher = pattern.matcher(numbers);
            String output = matcher.replaceAll("+7 ($2) $3-$4-$5");

            if (!isPhoneNumber) {
                System.out.println("Неверный формат номера");
            } else {
                System.out.println(output);
            }
        }
    }
}
