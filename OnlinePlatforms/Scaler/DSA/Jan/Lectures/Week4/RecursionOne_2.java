package OnlinePlatforms.Scaler.DSA.Jan.Lectures.Week4;

import Resources.Utilities.PrintHelper;

/**
 * @author Harish Velmurugan
 * @last-modified 29-01-2025
 * @since 29-01-2025
 */
public class RecursionOne_2 {


    private final PrintHelper printHelper = new PrintHelper();

    public static void main(String[] args) {

        // Inputs


        // Call Stack
        RecursionOne_2 recursionOne2 = new RecursionOne_2();

        int sum = recursionOne2.sumOfNNaturalNumbers(5);
        recursionOne2.print("Sum : ", sum);

        // Factorial Of N numbers
        int factorial = recursionOne2.factorial(5);
        recursionOne2.print("Factorial : ", factorial);

        recursionOne2.printAllNumbersInIncreasingOrder(5);
        recursionOne2.printAllNumbersInDecreasingOrder(10);

        int fib = recursionOne2.printNthFibonacciNumber(7);
        recursionOne2.print("Fib : ", fib);

    }

    /* Section : ----------------------------------- [ Problems ] ------------------------------------ */

    private int sumOfNNaturalNumbers(int N) {
        if (N == 0) {
            return 0;
        }
        return sumOfNNaturalNumbers(N - 1) + N;
    }


    private int factorial(int N) {
        if (N == 0) { // 0 and 1 both has factorial as 1
            return 1;
        }
        return factorial(N - 1) * N;
    }

    private void printAllNumbersInIncreasingOrder(int N) {
        if (N == 0) {
            return;
        }
        printAllNumbersInIncreasingOrder(N - 1);
        System.out.print(N);
    }

    private void printAllNumbersInDecreasingOrder(int N) {
        if (N == 0) {
            return;
        }
        System.out.print(N + " ");
        printAllNumbersInDecreasingOrder(N - 1);
    }

    private int printNthFibonacciNumber(int N) {
        if (N == 0) {
            return 0;
        } else if (N == 1) {
            return 1;
        }
        return printNthFibonacciNumber(N - 1) + printNthFibonacciNumber(N - 2);
    }



    /* Section : ------------------------------- [ Specific Utilities ] ------------------------------- */



    /* Section : ------------------------------- [ Generic Utilities ] ------------------------------- */

    private void print(String message) {
        printHelper.print(message, "");
    }

    private void print(String message, int a) {
        printHelper.print(message, a);
    }

    private void print(String message, int[] a) {
        printHelper.print(message, a);
    }

    private void print(String message, int[][] a) {
        printHelper.print(message, a);
    }

    /* Section : ------------------------------- [ Definition Resources ] ---------------------------- */

    private void definitions() {
        /*
         * Time complexit : (# total number of function calls * Time comp per function)
         * Space comp : # max active function call in stack * Space comp per function
         * Notebook_06012025 : Page 57
         * */
    }

    private void links() {
        /*
         *
         * academy/mentee-dashboard/class/345217/session?joinSession=1
         * */
    }

    /* Section : --------------------------------------- [ End ] ------------------------------------ */


}
