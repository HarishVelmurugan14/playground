package Resources.Interviews;

@SuppressWarnings("ReassignedVariable")
public class HarishPivotCode {
    public static int findPivot(int[] givenArray, int arrayLength, int rightSideSum) {

        int leftSideSum = 0;
        for (int i = 0; i < arrayLength; i++) {
            rightSideSum = rightSideSum - givenArray[i];
            if (leftSideSum == rightSideSum)
                return i;
            leftSideSum = leftSideSum + givenArray[i];
        }
        return -1;
    }

    public static void main(String[] args) {


         int[] givenArray = {-1,1, 5};
        //int[] givenArray = {3, 4};
        int rightSideSum = 0;
        for (int value : givenArray) {
            rightSideSum = rightSideSum + value;
        }
        System.out.println(findPivot(givenArray, givenArray.length, rightSideSum));
    }
}


