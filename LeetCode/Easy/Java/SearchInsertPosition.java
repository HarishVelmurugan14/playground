package LeetCode.Easy.Java;

public class SearchInsertPosition {
    @SuppressWarnings("ReassignedVariable")
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            System.out.println("L = "+left+" R =" + right);
            int mid = left + ((right-left) / 2);
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] < target){
                left = mid+1;
            }else{
                right = mid-1;
            }
            System.out.println(" OUT L = "+left+" R =" + right);
        }
        return left;
    }
}
