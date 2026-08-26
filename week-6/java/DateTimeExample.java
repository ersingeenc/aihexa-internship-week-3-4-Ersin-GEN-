import java.time.LocalDate;
import java.time.Period;

public class DateTimeExample {
    public static void main(String[] args) {
        LocalDate start = LocalDate.of(2026, 7, 6);
        LocalDate end = LocalDate.of(2026, 8, 31);

        Period period = Period.between(start, end);
        System.out.println("Staj tarih araligi: " + period.getMonths() +
                " ay " + period.getDays() + " gun");
    }
}
