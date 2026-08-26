import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparableComparatorExample {
    record Student(String name, int score) implements Comparable<Student> {
        @Override
        public int compareTo(Student other) {
            return this.name.compareToIgnoreCase(other.name);
        }
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(List.of(
                new Student("Zeynep", 85),
                new Student("Ali", 92),
                new Student("Mehmet", 78)
        ));

        students.sort(null);
        System.out.println("Doğal sıralama (isim): " + students);

        students.sort(Comparator.comparingInt(Student::score).reversed());
        System.out.println("Harici sıralama (puan): " + students);
    }
}
