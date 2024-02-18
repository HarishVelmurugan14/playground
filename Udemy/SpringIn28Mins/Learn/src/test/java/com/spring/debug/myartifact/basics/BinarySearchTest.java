package com.spring.debug.myartifact.basics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SpringBootApplicationBasics.class)
public class BinarySearchTest {


    //    @ExtendWith(SpringExtension.class) is used to integrate JUnit 5 with Spring.
//    @SpringBootTest is used to indicate that the tests should load the complete Spring application context.
    @Autowired
    BinarySearchImpl binarySearch;

    @Test
    void checkBinarySearch() {
        int actualResult =  binarySearch.binarySearch(new int[]{}, 5);
        Assertions.assertEquals(actualResult, 3);
    }
}
