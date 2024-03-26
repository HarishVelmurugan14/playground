package Utilities;

import java.util.HashMap;

public class PrintHelper {
    public void intArrayPrinter(int[] array) {
        for (Object element : array) {
            System.out.print(element);
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
