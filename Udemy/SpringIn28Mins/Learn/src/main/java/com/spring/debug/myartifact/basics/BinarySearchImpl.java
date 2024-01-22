package com.spring.debug.myartifact.basics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class BinarySearchImpl {

    private final Logger LOGGER = Logger.getLogger("BinarySearchImpl.class");
    @Autowired
    private SortAlgorithm sortAlgorithm;

    public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
        //Logic3
        LOGGER.info("Algorith name "+sortAlgorithm);
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
        // QuickSortAlgorithm quickSortAlgorithm = new QuickSortAlgorithm();
        // quickSortAlgorithm.sort(numbers);
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
