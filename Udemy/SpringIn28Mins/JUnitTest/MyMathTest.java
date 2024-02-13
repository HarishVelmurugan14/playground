package Udemy.SpringIn28Mins.JUnitTest;

import Udemy.SpringIn28Mins.JUnit.MyMath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyMathTest {
    private final MyMath myMath = new MyMath();

    @BeforeAll // @AfterAll
    void beforeAll(){}

    @BeforeEach // @AfterEach
    void beforeEach(){}

    @Test
    void calculate_three(){
        Assertions.assertEquals(33, myMath.calculateSum(new int[]{10, 11, 12}));
    }

}
