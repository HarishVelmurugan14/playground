package Coursera.RobertSedgewick.algorithms.com.dsa.week3.sorting;

import java.util.Arrays;

@SuppressWarnings("ALL")
public class QuickSort {
    public static int COUNTER = 0;

//    public static void main(String[] args) {
//        Integer[] a  = {3,9,1,8,2,3,7,6,3,0,2,4};
//        ThreeWayPartition(a,1,a.length-1);
//    }
    public static void standardPartition(Comparable[] a, int low, int high){

        // No swapping of pivot ; if less increment low; if high pause and proceed reverse path
        // In reverse path if it is greater decreement high; if it is less swap with low -> this cause forward path to proceed
        // if high less than low swap high value with pivot;
        //NOTE : For cases where pivot has duplicates it continuos to run

        int pivot = 0;
        while(high >= low){
           // System.out.println(Arrays.toString(a));
            if(a[low].compareTo(a[pivot]) < 0){
                low++;
            }else if(a[high].compareTo(a[pivot]) > 0){
                high--;
            } else if(a[high].compareTo(a[pivot]) < 0) {
                SortingBaseClass.swap(a,low,high);
                high--;
            }
        }
        SortingBaseClass.swap(a,pivot,high);
    }


    public static void ThreeWayPartition(Comparable[] a, int low, int high){

        // NOTE : Only foward path || Duplicate key case is solved
        // Swapping of pivot exist ; if less swap with pivot increment low and pivot; if greater swap with high , decreement high and proceed in forward direction
        // If equal increement low
        // if high less than low end
        int lowCopy = low;
        int highCopy = high;

        int pivot = 0;
        while(high>=low){
            COUNTER++;
            System.out.println(Arrays.toString(a));
            if(a[low].compareTo(a[pivot]) < 0){
                SortingBaseClass.swap(a,low,pivot);
                pivot++;
                low++;
            } else if(a[low].compareTo(a[pivot]) > 0) {
                SortingBaseClass.swap(a,low,high);
                high--;
            }else if(a[low].compareTo(a[pivot]) == 0){
                low++;
            }
        }
        ThreeWayPartition(a,lowCopy,pivot-1);
        ThreeWayPartition(a,high+1,highCopy);

        System.out.println("High - "+high + " Low - " + low + " Pivot - "+pivot);
    }

}
