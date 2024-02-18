package Udemy.SpringIn28Mins.JUnitTest;

import Udemy.SpringIn28Mins.JUnit.MyMath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyMathTest {
    private final MyMath myMath = new MyMath();

    @BeforeAll // @AfterAll
    static void beforeAll(){
        System.out.println("BeforeAll");
    }

    @BeforeEach // @AfterEach
    void beforeEach(){
        System.out.println("BeforeEach");
    }


    @Test
    void calculate_three(){
        System.out.println("Three Member Array");
        Assertions.assertEquals(33, myMath.calculateSum(new int[]{10, 11, 12}));
    }

    @Test
    void calculate_zero(){
        System.out.println("Zero Length Array");
        Assertions.assertEquals(0, myMath.calculateSum(new int[]{}));
    }

}
