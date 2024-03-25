package Utilities;

public class PrintHelper {
    public void intArrayPrinter(int[] array) {
        for (Object element : array) {
            System.out.print(element);
            System.out.print(",");
        }
        System.out.println();
    }
}
