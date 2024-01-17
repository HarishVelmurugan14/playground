package com.spring.learn.myartifact;

public class BinarySearchImpl {
	
	private SortAlgorithm sortAlgorithm;
	
	public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
		//Logic3
		this.sortAlgorithm = sortAlgorithm;
	}
	
	public int binarySearch(int[] numbers, int numberToBeSearched) {
		// ------------------------------------------------------------
		// Logic 1 Tight Coupling with direct implementation of sorting
		// ------------------------------------------------------------
		// Sort - search - result
		
		// ------------------------------------------------------------
		// Logic 2 Tight Coupling with sort implementation separated
		// ------------------------------------------------------------
		BubbleSortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm();
		bubbleSortAlgorithm.sort(numbers);
		// Search - result
		
		//Problem : What if new algorithm is introduced? All implementation needs to be altered
		
		// ------------------------------------------------------------
		// Logic 3 Loose Coupling using interface
		// ------------------------------------------------------------		
		sortAlgorithm.sort(numbers);
		//Search - result
		
		
		return 3;
	}
}
