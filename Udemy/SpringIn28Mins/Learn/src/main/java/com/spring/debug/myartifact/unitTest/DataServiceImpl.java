package com.spring.debug.myartifact.unitTest;

public class DataServiceImpl implements DataService{
    @Override
    public int[] retrieveAllData() {
        return new int[]{12,13,14,15};
    }
}
