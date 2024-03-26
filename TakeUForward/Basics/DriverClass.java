package TakeUForward.Basics;

import Utilities.PrintHelper;

import java.util.Arrays;

public class DriverClass {
    PrintHelper printHelper = new PrintHelper();

    public static void main(String[] args) {
        DriverClass driverClass = new DriverClass();
//        driverClass.patternMethods();
//        driverClass.recursionMethods();
//        driverClass.hashingMethods();
        driverClass.sortingMethods();
    }

    public void sortingMethods(){
        Sorting sorting = new Sorting();
        int[] arr = sorting.selectionSort(new int[]{9 ,3 ,6 ,2 ,0});
        printHelper.intArrayPrinter(arr);
        sorting.bubbleSort(new int[]{9 ,3 ,6 ,2 ,0}, 5);
        sorting.insertionSort(new int[]{7,2,3,4,5,6}, 6);
        sorting.mergeSortPseudocodeExample(); // Image reference
    }

    public void hashingMethods() {
        Hashing hashing = new Hashing();
        printHelper.intArrayPrinter(hashing.countFrequency(7, 20, new int[]{10, 7, 9, 8, 14, 20, 6}));
        printHelper.intArrayPrinter(hashing.getFrequencies(new int[]{19,17,16}));
    }

    public void recursionMethods() {
        Recursions recursions = new Recursions();
        recursions.sumOfFirstNNumbers(0, 1, 5);
        recursions.sumFirstN(5);
        recursions.sumFirstNUsingFormula(5);
        recursions.factorial(5);
        System.out.println(Arrays.toString(recursions.reverseArray(8, new int[]{3, 1, 1, 7, 4, 2, 6, 11})));
        System.out.println(recursions.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(recursions.isPalindromeNormal("A man, a plan, a canal: Panama"));
        System.out.println(recursions.isPalindromeNormal("dad"));
        System.out.println(recursions.isPalindromeNormal("dab , bad"));
        printHelper.intArrayPrinter(recursions.generateFibonacciNumbers(8));
        System.out.println(recursions.generateFibonacciValue(4));
        System.out.println(recursions.fibonacciInRecursion(2));
    }


    public void patternMethods() {
        Pattern pattern = new Pattern();
        pattern.createRectangleStarPattern(3);
        pattern.createRightAngledTrianglePattern(3);
        pattern.createRightAngledNumberPyramid(3);
        pattern.createRightAngledNumberPyramid2(3);
        pattern.pattern5(3);
        pattern.pattern6(3);
        pattern.pattern8(3);
        pattern.pattern11(3);
        pattern.pattern12(3);
        pattern.pattern13(3);
        pattern.pattern14(3);
    }
}
