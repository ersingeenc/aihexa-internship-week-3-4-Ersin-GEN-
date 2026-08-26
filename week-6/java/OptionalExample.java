import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        String email = null;

        String result = Optional.ofNullable(email)
                .orElse("E-posta bulunamadi");

        System.out.println(result);
    }
}
