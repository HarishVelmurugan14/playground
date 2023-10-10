package Coursera.RobertSedgewick.algorithms.com.dsa.week3.sorting;

import java.util.Arrays;

@SuppressWarnings("ALL")
public class InsertionSort {
    public void sort(Comparable[] array){
        sort(array, 0, array.length-1);
    }

    public void sort(Comparable[] a, int low, int high){

        for(int i=low+1; i<=high;i++){
            int currentRoot = i;
            int changePlace = i - 1;
            while(a[changePlace].compareTo(a[currentRoot]) > 0){
                SortingBaseClass.swap(a, currentRoot, changePlace);
                changePlace--;
                currentRoot--;
                if(changePlace < low){
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
