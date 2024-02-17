package com.spring.debug.myartifact.unitTest;

import java.util.Arrays;

public class SomeBusinessImpl {
    DataService dataService;

    public SomeBusinessImpl(DataService dataService) {
        this.dataService = dataService;
    }


    int fetchGreatestValue(){
        int[] array = dataService.retrieveAllData();
        Arrays.sort(array);
        return array[array.length-1];
    }
}
