import java.util.ArrayList;
import java.util.List;

public class ListArrayListExample {
    public static void main(String[] args) {
        List<String> tasks = new ArrayList<>();

        // Create
        tasks.add("Unit test yaz");
        tasks.add("Integration test yaz");

        // Read
        System.out.println("İlk görev: " + tasks.get(0));

        // Update
        tasks.set(1, "Integration testini güncelle");

        // Delete
        tasks.remove(0);

        System.out.println("Güncel liste: " + tasks);
    }
}
