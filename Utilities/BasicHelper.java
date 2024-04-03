package Utilities;

public class BasicHelper {
    public void swap(int a, int b, int[] nums) {
        int x = nums[a];
        nums[a] = nums[b];
        nums[b] = x;
    }

    public void reverse(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        reverse(arr, i, j);
    }

    public void reverse(int[] arr, int i, int j) {
        while (j > i) {
            swap(i, j, arr);
            i++;
            j--;
        }
    }

}
