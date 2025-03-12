package OnlinePlatforms.Scaler.DSA.Advanced.Part2;

import Resources.Utilities.PrintHelper;

import java.util.Stack;

/**
 * @author Harish Velmurugan
 * @last-modified 11-03-2025
 * @since 11-03-2025
 */
@SuppressWarnings("StringTemplateMigration")
public class d28_Queue_ImplementationAndProblems {


    private final PrintHelper printHelper = new PrintHelper();

    public static void main(String[] args) {

        // Inputs


        // Call Stack
        d28_Queue_ImplementationAndProblems d28_queue_implementationAndProblems = new d28_Queue_ImplementationAndProblems();
        d28_queue_implementationAndProblems.implementQueuesUsingStack(); // Q1


    }

    /* Section : ----------------------------------- [ Problems ] ------------------------------------ */

    public void implementQueuesUsingStack() {
        UserQueue userQueue = new UserQueue();
        UserQueue.push(3);
        UserQueue.push(4);
        UserQueue.push(5);
        UserQueue.push(6);
        System.out.println("Size : "+ UserQueue.size());
        System.out.println("Is Empty : "+ UserQueue.empty());
        System.out.println("Peek "+ UserQueue.peek());
        System.out.println("Pop "+ UserQueue.pop());
        UserQueue.push(7);
        System.out.println("Peek "+ UserQueue.peek());
    }

    public void optimal() {
        // Complexity : Time : [  ]
        // Complexity : Space : [  ]


    }

    /* Section : ------------------------------- [ Specific Utilities ] ------------------------------- */


    /* Section : ------------------------------- [ Generic Utilities ] ------------------------------- */

    private void print(String message) {
        printHelper.print(message, "");
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

    public static void populateOutputStackIfEmpty(){
        if(outputStack.isEmpty()){
            while(!inputStack.isEmpty()){
                outputStack.push(inputStack.pop());
            }
        }
    }
}


