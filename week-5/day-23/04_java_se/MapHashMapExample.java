import java.util.HashMap;
import java.util.Map;

public class MapHashMapExample {
    public static void main(String[] args) {
        Map<Integer, String> users = new HashMap<>();
        users.put(101, "Ada");
        users.put(102, "Grace");
        users.put(103, "Alan");

        System.out.println("102 numaralı kullanıcı: " + users.get(102));
        users.put(102, "Grace Hopper");
        users.remove(103);

        users.forEach((id, name) -> System.out.println(id + " -> " + name));
    }
}
