package SelfLearn.Java.Defaultpackage.Advanced.Null;

import java.util.Optional;
import java.util.function.Consumer;

public class Example {

    public static <T> void applyIfNotNull(Consumer<T> consumer, T value, boolean excludeEmpty) {
        Optional.ofNullable(value)
                .filter(val -> !excludeEmpty || !(val instanceof String && ((String) val).isEmpty()))
                .ifPresent(consumer);
    }

    public static void main(String[] args) {
        String value = "";
        int value1 = 98;
        String value2 = "";
        boolean filterEmpty = true;

        applyIfNotNull(System.out::println, value, filterEmpty);
        applyIfNotNull(System.out::println, value1, false);
        applyIfNotNull(System.out::println, value2, true);
        applyIfNotNull(System.out::println, value1, true);
    }
}
