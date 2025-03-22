package OnlinePlatforms.LeetCode.Topics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("UnusedReturnValue")
public class ArraysAndHashing {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hash = new HashSet<>();

        for(int x: nums){
            if(hash.contains(x)){
                return true;
            }
            hash.add(x);
        }
        return false;
    }

    public boolean isAnagram(String s, String t) {
        int n = s.length();
        if(n != t.length()) return false;
        int[] array = new int[26];

        for(int i = 0; i < n; i++){
            array[ s.charAt(i) - 'a']++;
            array[ t.charAt(i) - 'a']--;
        }
        for(int i=0; i<26; i++){
            if(array[i] != 0){
                return false;
            }
        }
        return true;
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(target - nums[0], 0);
        for(int i = 1; i< nums.length; i++){
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]), i};
            }
            int requiredPair = target - nums[i];
            if(!map.containsKey(requiredPair)){
                map.put(requiredPair, i);
            }
        }
        return null;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            int[] count = new int[26];
            for(char current : s.toCharArray()){
                count[current - 'a']++;
            }
            String key = Arrays.toString(count);

            map.putIfAbsent(key, new ArrayList());
            map.get(key).add(s);

            // List<String> list = new ArrayList();
            // if(map.containsKey(key)){
            //     list = map.get(key);
            //     list.add(s);
            //     map.put(key, list);

            // } else {
            //     list.add(s);
            //     map.put(key,list);
            // }
        }
        return new ArrayList<>(map.values());
    }

    public void rainWaterTrapped(int[] A) {
        // Complexity : Time : [ O(3N) ]
        // Complexity : Space : [ O(2N) ]
        int n = A.length;
        int totalWater = 0;
        int[] leftMaxArray = new int[n];
        int[] rightMaxArray = new int[n];
        int leftMax = A[0];
        for (int j = 1; j < n - 1; j++) {
            if (A[j - 1] > leftMax) {
                leftMax = A[j - 1];
            }
            leftMaxArray[j] = leftMax;
        }

        int rightMax = A[n - 1];
        for (int k = n - 2; k > 0; k--) {
            if (A[k + 1] > rightMax) {
                rightMax = A[k + 1];
            }
            rightMaxArray[k] = rightMax;
        }


        for (int i = 1; i < n - 1; i++) {
            int leftMaxIn = leftMaxArray[i];
            int rightMaxIn = rightMaxArray[i];
            int waterTrapped = Math.min(leftMaxIn, rightMaxIn) - A[i];
            if (waterTrapped > 0) {
                totalWater += waterTrapped;
            }
        }
        System.out.println(totalWater);
    }
}
