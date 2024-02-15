package practice1;

@FunctionalInterface
interface Predicate<T>{
    boolean test(T s);
}

public class Main {
    public static void main(String[] args) {
        Predicate<String> validator = pin -> pin != null && (pin.matches("\\d{4}") || pin.matches("\\d{6}"));
        System.out.println(validator.test("adsddf"));
        System.out.println(validator.test("1234"));
        System.out.println(validator.test("123456"));
        System.out.println(validator.test("123a"));
        System.out.println(validator.test("12345"));
    }
}