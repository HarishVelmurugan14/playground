package OnlinePlatforms.LeetCode;

import OnlinePlatforms.LeetCode.Topics.ArraysAndHashing;
import OnlinePlatforms.LeetCode.Topics.BackTracking;
import OnlinePlatforms.LeetCode.Topics.Graphs;
import OnlinePlatforms.LeetCode.Topics.Heaps;
import OnlinePlatforms.LeetCode.Topics.LinkedList;

@SuppressWarnings("SpellCheckingInspection")
public class LeetCodeBase {

    public static void main(String[] args) {
        ArraysAndHashing();
        LinkedList();
        BackTracking();
        Heaps();
    }

    @SuppressWarnings("DataFlowIssue")
    private static void ArraysAndHashing() {
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
        arraysAndHashing.topKFrequentElements(null, 3); // LC347
        arraysAndHashing.profitOfBeggarsSittingContiguoslyGettingRandomDonation(1, null); // LC370 // Locked // Range Addition

        // ---------------------------------------- Hard -----------------------------------------

        arraysAndHashing.rainWaterTrapped(null); // LC42

    }

    private static void LinkedList() {
        LinkedList linkedList = new LinkedList();

        // ---------------------------------------- Easy -----------------------------------------
        linkedList.mergeTwoSortedLinkedList(null, null); // LC21
        linkedList.detectionOfCycles(null); // LC141
        linkedList.detectStartOfTheCycle(null); // LC142
        linkedList.isPalindrome(null); // LC234
        linkedList.middleNodeOfALinkedList(null); // LC876

        // ---------------------------------------- Medium -----------------------------------------
        linkedList.addTwoNumbersInReverseOrderAndReturnAsLinkedList(null, null); // LC02
        linkedList.swapPairs(null); // LC24
        linkedList.mergeSortLinkedList(null); // LC148

        // ---------------------------------------- Hard -----------------------------------------
    }

    private static void BackTracking() {
        BackTracking backTracking = new BackTracking();

        // ---------------------------------------- Easy -----------------------------------------


        // ---------------------------------------- Medium -----------------------------------------
        backTracking.generateParenthesis(3); // LC22
        backTracking.generatePermutations_old(new int[]{1, 2, 3}); // LC46
        backTracking.generateSubsets(new int[]{1, 2, 3}); // LC78
        backTracking.generateSubSequence("", "abc"); // LC78

        // ---------------------------------------- Hard -----------------------------------------
    }

    private static void Heaps() {
        Heaps heaps = new Heaps();

        // ---------------------------------------- Easy ------------------------------------------
        heaps.kThLargestElement(); //LC703
        heaps.containsNearbyDuplicate(null, 3); //LC219

        // ---------------------------------------- Medium -----------------------------------------
        heaps.minimumMeetingRoomsRequired(3, null); //LC253

        // ---------------------------------------- Hard -------------------------------------------
        heaps.mergeKLists(null); //LC23
        heaps.minWindowSubstring("", ""); //LC76
        heaps.distributeCandys(null); //LC135
        heaps.medianRunningArray(); //LC295
    }

    private static void Graphs() {
        Graphs graphs = new Graphs();

        // ---------------------------------------- Easy ------------------------------------------

        // ---------------------------------------- Medium -----------------------------------------
        graphs.rottenOranges(null); //LC994
        graphs.connectingBridges(3, null); //LC1135
        graphs.minCostConnectPoints(null); //LC1584

        // ---------------------------------------- Hard -------------------------------------------

    }

}

