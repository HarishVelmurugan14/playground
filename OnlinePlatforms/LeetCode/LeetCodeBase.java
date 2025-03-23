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
        arraysAndHashing.plusOneToAndIntegerArray(null); // LC66
        arraysAndHashing.containsDuplicate(null); // LC217
        arraysAndHashing.isAnagram("racecar", "carrace"); // LC242
        arraysAndHashing.rowWithMaximumNumberOfOnes(null); // LC1428 // Locked // Left column with least one

        // ---------------------------------------- Medium ---------------------------------------

        arraysAndHashing.groupAnagrams(null); // LC49
        arraysAndHashing.maxSumSubArray(null); // LC53
        arraysAndHashing.profitOfBeggarsSittingContiguoslyGettingRandomDonation(1, null); // LC370 // Locked // Range Addition

        // ---------------------------------------- Hard -----------------------------------------

        arraysAndHashing.rainWaterTrapped(null); // LC42

    }

}

