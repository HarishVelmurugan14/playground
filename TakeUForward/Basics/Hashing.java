package TakeUForward.Basics;

public class Hashing {
    public int[] countFrequency(int n, int x, int[] nums) {
        int[] result = new int[n];
        for (int num : nums) {
            if (num <= n) {
                result[num - 1] = result[num - 1] + 1;
            }
        }
        return result;
    }
}
