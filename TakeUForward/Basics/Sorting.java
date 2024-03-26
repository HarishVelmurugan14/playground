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

    public void bubbleSort(int[] arr, int n) {
        for (int i = n - 2; i >= 0; i--) {
            int didSwap = 0;
            for (int j = 0; j <= i; j++) {
                if (arr[j + 1] < arr[j]) {
                    int x = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = x;
                    didSwap = 1; // Check if already sorted ?
                }
            }
            if (didSwap == 0) {
                break;
            }
        }

        PrintHelper printHelper = new PrintHelper();
        printHelper.intArrayPrinter(arr);
    }

    public void insertionSort(int[] arr, int n){
        for (int i = 1; i < n; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                int x = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = x;
                j--;
            }
        }
        PrintHelper printHelper = new PrintHelper();
        printHelper.intArrayPrinter(arr);
    }

    public void mergeSortPseudocodeExample() {
//            Refer Resources/MergeSortMyOwnPesucodeImplementation.png
    }
}
