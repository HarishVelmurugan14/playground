package Utilities;

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
        System.out.println(message);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
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
