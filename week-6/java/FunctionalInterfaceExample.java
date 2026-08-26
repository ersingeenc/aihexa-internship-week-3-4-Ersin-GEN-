import java.util.function.Predicate;
import java.util.function.Consumer;

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        Predicate<Integer> adult = age -> age >= 18;
        Consumer<String> print = text -> System.out.println(text);

        print.accept("20 yas yetiskin mi? " + adult.test(20));
    }
}
