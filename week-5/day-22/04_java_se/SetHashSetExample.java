import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetHashSetExample {
    public static void main(String[] args) {
        List<String> tags = List.of("java", "test", "java", "git", "test");
        Set<String> uniqueTags = new HashSet<>(tags);

        System.out.println("Orijinal: " + tags);
        System.out.println("Tekrarsız: " + uniqueTags);
        System.out.println("Benzersiz eleman sayısı: " + uniqueTags.size());
    }
}
