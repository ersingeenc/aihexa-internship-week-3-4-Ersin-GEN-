public class GenericsExample {
    static class Box<T> {
        private T value;
        Box(T value) { this.value = value; }
        T get() { return value; }
        void set(T value) { this.value = value; }
    }

    public static void main(String[] args) {
        Box<String> textBox = new Box<>("Contract Test");
        Box<Integer> countBox = new Box<>(24);

        String text = textBox.get(); // cast gerekmez
        int count = countBox.get();

        System.out.println(text + " - Gün " + count);
    }
}
