import java.util.List;

public class LambdaExample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(5, 2, 8, 1, 10);
        numbers.stream()
                .filter(n -> n > 4)
                .sorted()
                .forEach(System.out::println);
    }
}
