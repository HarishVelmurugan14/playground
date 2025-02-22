package OnlinePlatforms.Scaler.DSA;

import OnlinePlatforms.Scaler.DSA.Advanced.Part2.d21_Searching_BinarySearchOnArray;
import OnlinePlatforms.Scaler.DSA.Feb.Week2.Hashing2_1;
import OnlinePlatforms.Scaler.DSA.Feb.Week2.Sorting2QuickSortComparatorProblems;
import OnlinePlatforms.Scaler.DSA.Jan.Lectures.Week2.OneDimensionalArray_3;
import OnlinePlatforms.Scaler.DSA.Jan.Lectures.Week3.Arrays_InterviewProblems_2;
import OnlinePlatforms.Scaler.DSA.Jan.Lectures.Week3.BitWiseOperatorsOne_3;
import OnlinePlatforms.Scaler.DSA.Jan.Lectures.Week3.TwoDimensionalArray_1;

public class Index {
    public static void main(String[] args) {


        /* ------------------------------------------ One Dimensional Array ------------------------------------------*/
        OneDimensionalArray_3 oneDimensionalArray3 = new OneDimensionalArray_3();

        oneDimensionalArray3.maximumSumContiguosSubArray(new int[]{1, 1});
        oneDimensionalArray3.profitOfBeggarsSittingContiguoslyGettingRandomDonation();
        oneDimensionalArray3.rainWaterTrappedBetween2Buildings();

        oneDimensionalArray3.addOneToNumberProvidedAsArray();
        //Problem 5

        /* ------------------------------------------ Two Dimensional Array ------------------------------------------*/
        TwoDimensionalArray_1 twoDimensionalArray1 = new TwoDimensionalArray_1();

        twoDimensionalArray1.generateSquareMatrixInSpiralOrder(4);
        twoDimensionalArray1.searchInARowWiseAndColumnWiseSortedMatrix();
        twoDimensionalArray1.sumOfAllPossibleSubMatrices(new int[][]{});

        //Problem 4
        //Problem 5

        /* ------------------------------------------ Interview Problems Array ---------------------------------------*/
        Arrays_InterviewProblems_2 interviewProblems2 = new Arrays_InterviewProblems_2();

        interviewProblems2.firstMissingNaturalNumber();
        interviewProblems2.mergeIntervalAndProvidePointsMerged();

        interviewProblems2.insertANewIntervalAndMergeIfPossible();
        interviewProblems2.nextPermutation();

        /* ------------------------------------------ Bit Manipulation 1 ---------------------------------------------*/
        BitWiseOperatorsOne_3 bitWiseOperatorsOne3 = new BitWiseOperatorsOne_3();

        bitWiseOperatorsOne3.setTheIthBitInNumberN(5, 0);
        bitWiseOperatorsOne3.unSetTheIthBitInNumberN(5, 0);
        bitWiseOperatorsOne3.toggleBitIInNumberN(5, 0);
        bitWiseOperatorsOne3.checkIfIthBitIsSetOrUnset(5, 0);
        bitWiseOperatorsOne3.countNumberOfSetBits(5);
        bitWiseOperatorsOne3.arrayContainingOnlyOneDistintNumber(new int[]{});

        bitWiseOperatorsOne3.findNthMagicNumber(5);
        bitWiseOperatorsOne3.helpFromSam(5);
        bitWiseOperatorsOne3.findingGoodDaysForAlexCat();

        /* ------------------------------------------ Bit Manipulation 2 ---------------------------------------------*/

        /* ------------------------------------------ Hashing 2 ------------------------------------------------------*/
        Hashing2_1 hashing21 = new Hashing2_1();

        hashing21.findThePairWithSumAsK(); // Q1
        hashing21.countOfPairsWithDifferenceEqualsK(); // Q2
        hashing21.countOfSubArrayWithSumEqualsK(); // Q3
        hashing21.distinctNumbersInWindow(); // Q4
        hashing21.longestSubArrayWithSumAsZero(); // Q5

        hashing21.countThePairWithSumAsK(); // AQ1
        // AQ2

        hashing21.longestSubArrayWithSumAsK(); // Ext
        hashing21.firstNonRepeatingElementInAnArray(); // Ext

        /* ------------------------------------------ Quick Sort & Comparator ----------------------------------------*/
        Sorting2QuickSortComparatorProblems sorting2QuickSortCmp = new Sorting2QuickSortComparatorProblems();

        sorting2QuickSortCmp.sortByColor();
        sorting2QuickSortCmp.quickSort(new int[]{}, 0, 10);

        /* ------------------------------------------ ADVANCED DSA 2 -------------------------------------------------*/
        /* ------------------------- Day 21 - DSA : Searching 1: Binary Search on Array ------------------------------*/
        d21_Searching_BinarySearchOnArray d21SearchingBinarySearchOnArray = new d21_Searching_BinarySearchOnArray();

        d21SearchingBinarySearchOnArray.searchForStartAndEndIndexOfAnElementInAnArray(); // Q1
        d21SearchingBinarySearchOnArray.positionWhereTargetIsPresentOrShouldBeInserted(); // Q2
        d21SearchingBinarySearchOnArray.singleElementInASortedArray(); // Q3
    }
}
