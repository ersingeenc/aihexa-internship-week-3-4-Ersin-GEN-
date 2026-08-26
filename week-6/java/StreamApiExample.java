import java.util.List;

public class StreamApiExample {
    public static void main(String[] args) {
        List<String> names = List.of("Ali", "Mehmet", "Ayse", "Ece");

        names.stream()
                .filter(name -> name.length() >= 4)
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }
}
