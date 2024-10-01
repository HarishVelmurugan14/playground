package SelfLearn.Java.Defaultpackage.Fundamental.Concepts;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class ModernJava {
    public final void definitions(){
        biFunctionExample(); //<input, input, output>
        mergeMethodCallHashMap(); //<key, value, biFunction>
    }


    public void biFunctionExample() {
        // Define two functions
        Function<Integer, Integer> square = x -> x * x;
        Function<Integer, Integer> increment = x -> x + 1;

        // Define a BiFunction that applies two functions sequentially
        // input, input, output
        BiFunction<Integer, Integer, Integer> combinedFunction = (input, factor) -> square.apply(input) + increment.apply(factor);

        // Apply the BiFunction
        int result = combinedFunction.apply(3, 2);
        System.out.println("Result: " + result); // Output: 14 (3^2 + (2+1))
    }

    public void mergeMethodCallHashMap() {
        Map<String, Integer> map = new HashMap<>();

        // Adding key-value pairs to the map
        map.put("a", 1);
        map.put("b", 2);

        // Merge a new key-value pair into the map
        map.merge("c", 3, (oldValue, newValue) -> oldValue + newValue);
        System.out.println("Map after merging 'c': " + map);

        // Merge a value for an existing key
        map.merge("b", 5, Integer::sum);
        map.merge("c", 5, Integer::max);
        System.out.println("Map after merging 'b': " + map);
    }

}
