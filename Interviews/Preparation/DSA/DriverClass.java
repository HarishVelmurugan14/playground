package Interviews.Preparation.DSA;

import Interviews.Preparation.DSA.Search.BinarySearch;
import Interviews.Preparation.DSA.Tree.BinarySearchTree;

public class DriverClass {
    public static void main(String[] args) {

        search();
        tree();
    }

    private static void tree() {
        //Must Know
        BinarySearchTree binarySearchTree = BinarySearchTree.getInstance();
        binarySearchTree.init();

    }


    public static void search() {
        // Must Know
        BinarySearch binarySearch = BinarySearch.getInstance();
        binarySearch.init();
        // Good To Know
    }
}
