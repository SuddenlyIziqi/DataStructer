package Test;

public class TestDuotai {
    private static Animal animal;

    public static void main(String[] args) {
        test(new Cat());
        test(new Dog());

    }

    public static void test(Animal animal) {
        animal.say();
    }
}
