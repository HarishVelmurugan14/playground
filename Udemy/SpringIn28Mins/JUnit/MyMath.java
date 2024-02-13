package Udemy.SpringIn28Mins.JUnit;

public class MyMath {
    public int calculateSum(int[] numbers){
        int result = 0;
        for (int i : numbers){
            result = result + i;
        }
        return result;
    }
}
