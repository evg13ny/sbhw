import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class Main {

    public static void main(String[] args) {
        System.out.println(getPeriodFromBirthday());
    }

    private static String getPeriodFromBirthday() {
        LocalDate birthday = LocalDate.of(1995, Month.MAY, 23);
        LocalDate today = LocalDate.now();
        Period period = Period.between(birthday, today);
        return period.getYears() + " years, " + period.getMonths() + " months, " + period.getDays() + " days";
    }
}
