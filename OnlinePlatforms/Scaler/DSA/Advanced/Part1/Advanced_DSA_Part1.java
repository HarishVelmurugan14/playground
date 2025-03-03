package OnlinePlatforms.Scaler.DSA.Advanced.Part1;

import OnlinePlatforms.Scaler.DSA.Feb.Week2.Hashing2_1;
import OnlinePlatforms.Scaler.DSA.Feb.Week2.Sorting2QuickSortComparatorProblems;

import java.util.ArrayList;

@SuppressWarnings("DataFlowIssue")
public class Advanced_DSA_Part1 {
    public void implementations() {
        Arrays();
        BitManipulations();
        Recursions();
    }

    private void Arrays() {
        /* ------------------------- Day 08 - DSA: Arrays 1 : 1Dimensional Array -------------------------------------*/
        d08_Arrays_OneDimensional d08_arrays_oneDimensional = new d08_Arrays_OneDimensional();

        d08_arrays_oneDimensional.maximumSumContiguosSubArray(new int[]{1, 1}); //Q1
        d08_arrays_oneDimensional.profitOfBeggarsSittingContiguoslyGettingRandomDonation(); // Q2
        d08_arrays_oneDimensional.rainWaterTrappedBetween2Buildings(); // Q3

        d08_arrays_oneDimensional.addOneToNumberProvidedAsArray(); // AQ1
        // AQ2

        /* ------------------------- Day 09 - DSA: Arrays 2 : 2Dimensional Array -------------------------------------*/
        d09_Arrays_TwoDimensional d09_Arrays_TwoDimensional = new d09_Arrays_TwoDimensional();

        d09_Arrays_TwoDimensional.generateSquareMatrixInSpiralOrder(4); // Q1
        d09_Arrays_TwoDimensional.searchInARowWiseAndColumnWiseSortedMatrix(); // Q2
        d09_Arrays_TwoDimensional.sumOfAllPossibleSubMatrices(new int[][]{}); // Q3

        // AQ1
        // AQ2

        /* ------------------------- Day 10 - DSA: Arrays 3 : Interview Problems -------------------------------------*/
        d10_Arrays_InterviewProblems d10_Arrays_InterviewProblems = new d10_Arrays_InterviewProblems();

        d10_Arrays_InterviewProblems.firstMissingNaturalNumber(); // Q1
        d10_Arrays_InterviewProblems.mergeIntervalAndProvidePointsMerged(); // Q2

        d10_Arrays_InterviewProblems.insertANewIntervalAndMergeIfPossible(); // AQ1
        d10_Arrays_InterviewProblems.nextPermutation();
    }

    private void BitManipulations() {
        /* ------------------------- Day 11 - DSA: Bit Manipulation 1 ------------------------------------------------*/
        d11_BitWiseManipulations1 d11_BitWiseManipulations1 = new d11_BitWiseManipulations1();

        d11_BitWiseManipulations1.setTheIthBitInNumberN(5, 0);
        d11_BitWiseManipulations1.unSetTheIthBitInNumberN(5, 0);
        d11_BitWiseManipulations1.toggleBitIInNumberN(5, 0);
        d11_BitWiseManipulations1.checkIfIthBitIsSetOrUnset(5, 0);
        d11_BitWiseManipulations1.countNumberOfSetBits(5);
        d11_BitWiseManipulations1.arrayContainingOnlyOneDistintNumber(new int[]{});

        d11_BitWiseManipulations1.findNthMagicNumber(5); // AQ1
        d11_BitWiseManipulations1.helpFromSam(5); // AQ2
        d11_BitWiseManipulations1.findingGoodDaysForAlexCat(); // AQ3

        /* ------------------------- Day 12 - DSA: Bit Manipulation 2 ------------------------------------------------*/
        d12_BitWiseManipulations2 d12_BitWiseManipulations2 = new d12_BitWiseManipulations2();

        d12_BitWiseManipulations2.tripleTrouble(); // Q1
        d12_BitWiseManipulations2.twoUniqueElements(); // Q2
        d12_BitWiseManipulations2.numberOfSubArraysWithOr1(null); // Q3

        d12_BitWiseManipulations2.findMinXor(); // AQ1
        d12_BitWiseManipulations2.strangeEqualityWithFormula(5); // AQ2
        d12_BitWiseManipulations2.sumAfterBitwiseOROperatorOnAllSubArraysOfAnArray(); // AQ3
        d12_BitWiseManipulations2.missingTwoNumbersInRangeNPlus2(); // AQ4
    }

    private void Recursions() {

        /* ------------------------- Day 13 - DSA: Recursion 1 -------------------------------------------------------*/
        d13_Recursions1 d13_recursions1 = new d13_Recursions1();

        // Q1 - One Word
        d13_recursions1.factorial(5); // Q2
        d13_recursions1.printNthFibonacciNumber(3); // Q3
        d13_recursions1.printAllNumbersInIncreasingOrder(3); // Q4
        d13_recursions1.printAllNumbersInDecreasingOrder(3); // Q5

        // AQ1 - One Word
        d13_recursions1.findSumOfDigitsOfANumber(2); // AQ2
        d13_recursions1.printNNumbersFirstInDescendingThenInAscendingOrder(5); // AQ3

        /* ------------------------- Day 14 - DSA: Recursion 2 -------------------------------------------------------*/
        d14_Recursions2 d14_recursions2 = new d14_Recursions2();

        d14_recursions2.checkForPalindrome(null, 0, 0); // Q1
        d14_recursions2.towerOfHanoi_list(4, 1, 2, 3, new ArrayList<>()); // Q2
        d14_recursions2.allIndicesOfATargetInAnArray_Yahnit(null, 0, 3); // Q3
        d14_recursions2.printArrayUsingRecursion(null, 0); // Q4
        d14_recursions2.powerOfANumberUsingRecursion(); // Q5

        d14_recursions2.isMagicNumber(4); // AQ1
        // AQ2
        // AQ3
        // AQ4
    }

    private void Hashing() {
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
    }

    private void Sorting() {
        /* ------------------------------------------ Quick Sort & Comparator ----------------------------------------*/
        Sorting2QuickSortComparatorProblems sorting2QuickSortCmp = new Sorting2QuickSortComparatorProblems();

        sorting2QuickSortCmp.sortByColor();
        sorting2QuickSortCmp.quickSort(new int[]{}, 0, 10);
    }

    ;
}
