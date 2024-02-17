package com.spring.debug.myartifact.unitTest;

public class DriverClass {
    public static void main(String[] args) {
        SomeBusinessImpl someBusiness = new SomeBusinessImpl(new DataServiceImpl());
        System.out.println(someBusiness.fetchGreatestValue());
    }
}
