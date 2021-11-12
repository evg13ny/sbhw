import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        int day = 31;
        int month = 12;
        int year = 1990;

        System.out.println(collectBirthdays(year, month, day));

    }

    public static String collectBirthdays(int year, int month, int day) {

        //TODO реализуйте метод для построения строки в следующем виде
        //0 - 31.12.1990 - Mon
        //1 - 31.12.1991 - Tue

        LocalDate birthday = LocalDate.of(year, month, day);
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy - E", Locale.ENGLISH);
        String text = "";

        for (int age = 0; !birthday.isAfter(today); age++) {
            text = text + age + " - " + formatter.format(birthday) + System.lineSeparator();
            birthday = birthday.plusYears(1);
        }

        return text;
    }
}
