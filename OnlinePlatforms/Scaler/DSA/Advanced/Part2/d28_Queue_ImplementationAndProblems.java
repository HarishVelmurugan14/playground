package OnlinePlatforms.Scaler.DSA.Advanced.Part2;

import Resources.Utilities.PrintHelper;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Harish Velmurugan
 * @last-modified 11-03-2025
 * @since 11-03-2025
 */
@SuppressWarnings({"StringTemplateMigration", "DataFlowIssue", "UnusedReturnValue"})
public class d28_Queue_ImplementationAndProblems {


    private final PrintHelper printHelper = new PrintHelper();

    public static void main(String[] args) {

        // Inputs


        // Call Stack
        d28_Queue_ImplementationAndProblems d28_queue_implementationAndProblems = new d28_Queue_ImplementationAndProblems();
        d28_queue_implementationAndProblems.implementQueuesUsingStack(); // Q1
        d28_queue_implementationAndProblems.parkingIceCreamTruck(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3); // Q2

        d28_queue_implementationAndProblems.maximumInAFixedSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3); // LC239


    }

    /* Section : ----------------------------------- [ Problems ] ------------------------------------ */


    public int[] parkingIceCreamTruck(int[] A, int B) {
        Deque<Integer> deque = new LinkedList<>();
        int N = A.length;
        int[] res = new int[N - B + 1];
        int indexToBeRemoved = 0;
        for (int i = 0; i < N; i++) {
            while (!deque.isEmpty() && A[i] >= A[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.offerLast(i);
//            printDeque(deque, A);
            if (i >= B - 1) {
                res[indexToBeRemoved] = A[deque.peekFirst()];
                if (deque.peekFirst() == indexToBeRemoved) {
                    deque.removeFirst();
                }
                indexToBeRemoved++;
            }
        }
        return res;
    }


    public int[] maximumInAFixedSlidingWindow(int[] nums, int k) {
        int N = nums.length;
        int[] res = new int[N - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        int index = 0;

        for (int i = 0; i < N; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                System.out.println(nums[i] + " - " + nums[deque.peekLast()]);
                deque.removeLast();
            }
            deque.offerLast(i);
            if (i >= k - 1) {
                res[index] = nums[deque.peekFirst()];
                if (index == deque.peekFirst()) {
                    deque.pop();
                }
                index++;
            }
        }
        return res;
    }

    public int firstUniqueCharacterInAString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] array = s.toCharArray();
        int N = array.length;

        Deque<Integer> deque = new LinkedList<>();

        for(int i=0; i < N;i++){
            char x = array[i];
            if(!map.containsKey(x)){
                deque.offerLast(i);
                map.put(x, 1);
            } else {
                map.put(x, map.get(x) + 1);
            }
        }
        while(!deque.isEmpty()){
            int index = deque.pollFirst();
            if(map.get(array[index]) == 1){
                return index;
            }
        }
        return -1;
    }

    public void implementQueuesUsingStack() {
        UserQueue userQueue = new UserQueue();
        UserQueue.push(3);
        UserQueue.push(4);
        UserQueue.push(5);
        UserQueue.push(6);
        System.out.println("Size : " + UserQueue.size());
        System.out.println("Is Empty : " + UserQueue.empty());
        System.out.println("Peek " + UserQueue.peek());
        System.out.println("Pop " + UserQueue.pop());
        UserQueue.push(7);
        System.out.println("Peek " + UserQueue.peek());
    }

    public void printDeque(Deque<Integer> deque, int[] A) {
        for (Integer num : deque) {
            System.out.print(A[num] + " -> ");
        }
    }

    /* Section : ------------------------------- [ Specific Utilities ] ------------------------------- */


    /* Section : ------------------------------- [ Generic Utilities ] ------------------------------- */

    private void print(String message, int[] arr) {
        printHelper.print(message, arr);
    }

    /* Section : ------------------------------- [ Definition Resources ] ---------------------------- */

    private void definitions() {
        /**/
    }

    private void links() {
        /**/
    }

    /* Section : --------------------------------------- [ End ] ------------------------------------ */


}

class UserQueue {
    private static Stack<Integer> inputStack;
    private static Stack<Integer> outputStack;

    UserQueue() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    public static void push(int X) {
        inputStack.push(X);
    }

    public static int pop() {
        populateOutputStackIfEmpty();
        return outputStack.pop();
    }

    public static int peek() {
        populateOutputStackIfEmpty();
        return outputStack.peek();
    }

    public static boolean empty() {
        return (inputStack.isEmpty() && outputStack.isEmpty());
    }

    public static int size() {
        return inputStack.size() + outputStack.size();
    }

    public static void populateOutputStackIfEmpty() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
    }
}


