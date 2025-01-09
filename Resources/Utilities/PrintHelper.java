package Resources.Utilities;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PrintHelper {

    public void print(String message, Object o) {
        System.out.println(message + o);
    }

    public void print(String message, int[] array) {
        System.out.println(message + Arrays.toString(array));
    }

    public void print(String message, int[][] matrix) {
        for (int[] subArray : matrix) {
            System.out.print("[");
            for (int num : subArray) {
                System.out.print(num + " ");
            }
            System.out.println("]");
        }
    }


    public <T> void print(String message, List<T> list) {
        System.out.print(message);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i == list.size() - 1) {
                break;
            }
            System.out.print(",");
        }
        System.out.println();
    }

    public void hashMapPrinter(HashMap<Integer, Integer> hashMap) {
        for (int object : hashMap.keySet()) {
            System.out.println(object + " - " + hashMap.get(object));
        }
    }
}
