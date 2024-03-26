package TakeUForward.Basics;

import Utilities.PrintHelper;

public class Sorting {
    public int[] selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            int minValue = arr[i];
            for (int j = i+1; j < n; j++) {
                if (arr[j] < minValue) {
                    minIndex = j;
                    minValue = arr[j];
                }
            }
            int x = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = x;
        }
        return arr;
    }
}
