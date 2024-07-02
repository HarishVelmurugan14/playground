package Interviews.Preparation.DSA.Search;

public class BinarySearch {

    private BinarySearch() {

    }

    public static BinarySearch getInstance() {
        return new BinarySearch();
    }

    public void init() {
        int[] a = new int[10];
        runBinarySearchRecursively(a, 4, 0, a.length - 1);
    }

    //Preferred Approach : Find pivot check value move window
    private int runBinarySearchRecursively(int[] sortedArray, int key, int low, int high) {
        int pivot = low + ((high - low) / 2);

        if (high < low) {
            return -1;
        }

        if (key == sortedArray[pivot]) {
            return pivot;
        } else if (key < sortedArray[pivot]) {
            return runBinarySearchRecursively(
                    sortedArray, key, low, pivot - 1);
        } else {
            return runBinarySearchRecursively(
                    sortedArray, key, pivot + 1, high);
        }
    }

    private int runBinarySearchIteratively(int[] sortedArray, int key, int low, int high) {
        int index = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (sortedArray[mid] < key) {
                low = mid + 1;
            } else if (sortedArray[mid] > key) {
                high = mid - 1;
            } else if (sortedArray[mid] == key) {
                index = mid;
                break;
            }
        }
        return index;
    }
}
