package SelfLearn.Java.Defaultpackage.Advanced.Threads;

public class ThreadLocalClass {

    // Define a ThreadLocal variable
    private static ThreadLocal<Integer> threadLocalValue = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {
        // Set thread-local value in the main thread
        threadLocalValue.set(1);

        // Create and start a new thread
        Thread thread = new Thread(() -> {
            // Each thread gets its own initialized copy of threadLocalValue
            threadLocalValue.set(2);
            System.out.println("Thread-local value in new thread: " + threadLocalValue.get());
        });
        thread.start();

        // Access thread-local value in the main thread
        System.out.println("Thread-local value in main thread: " + threadLocalValue.get());
    }
}
