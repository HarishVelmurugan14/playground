package Resources.Interviews.Preparation.DSA;

import OnlinePlatforms.Coursera.RobertSedgewick.algorithms.com.dsa.week3.sorting.InsertionSort;
import OnlinePlatforms.Coursera.RobertSedgewick.algorithms.com.dsa.week3.sorting.MergeSort;
import OnlinePlatforms.Coursera.RobertSedgewick.algorithms.com.dsa.week3.sorting.OptimizedQuickSort;
import Resources.Interviews.Preparation.DSA.Search.BinarySearch;
import Resources.Interviews.Preparation.DSA.Tree.BinarySearchTree;
import Resources.Interviews.Preparation.DSA.Tree.RedBlackBST;

public class DriverClass {
    public static void main(String[] args) {

        sort();
        search();
        tree();
    }

    private static void sort() {
        //Must Know
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(new Integer[10]); // Small Data
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(new Integer[10], new Integer[10], 0, 9);
        OptimizedQuickSort optimizedQuickSort = new OptimizedQuickSort();
        optimizedQuickSort.sort(new Integer[10]);

    }

    public static void search() {
        // Must Know
        BinarySearch binarySearch = BinarySearch.getInstance();
        binarySearch.init();
        // Good To Know
    }

    private static void tree() {
        //Must Know
        BinarySearchTree.init();
        RedBlackBST.init(); // Most Efficient

    }
}
