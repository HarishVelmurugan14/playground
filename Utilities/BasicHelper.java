package Utilities;

public class BasicHelper {
    public void swap(int a, int b, int[] nums) {
        int x = nums[a];
        nums[a] = nums[b];
        nums[b] = x;
    }

}
