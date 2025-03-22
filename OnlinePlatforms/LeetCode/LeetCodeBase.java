package OnlinePlatforms.LeetCode;

import OnlinePlatforms.LeetCode.Topics.ArraysAndHashing;

@SuppressWarnings("SpellCheckingInspection")
public class LeetCodeBase {

    public static void main(String[] args) {
        ArraysAndHashing();
    }

    @SuppressWarnings("DataFlowIssue")
    private static void ArraysAndHashing(){
        ArraysAndHashing arraysAndHashing = new ArraysAndHashing();

        // ---------------------------------------- Easy -----------------------------------------

        arraysAndHashing.twoSum(null, 7); // LC1
        arraysAndHashing.containsDuplicate(null); // LC217
        arraysAndHashing.isAnagram("racecar", "carrace"); // LC242

        // ---------------------------------------- Medium ---------------------------------------

        arraysAndHashing.groupAnagrams(null); // LC49

        // ---------------------------------------- Hard -----------------------------------------

        arraysAndHashing.rainWaterTrapped(null); // LC42

    }

}

