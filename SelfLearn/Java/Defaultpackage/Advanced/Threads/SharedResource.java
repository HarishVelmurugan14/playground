package SelfLearn.Java.Defaultpackage.Advanced.Threads;

public class SharedResource {
    private volatile boolean exit = false;
//    private static boolean exit = false;

    public boolean shouldExit() {
        return exit;
    }

    public void setExit() {
        exit = true;
    }

    public void myMethod() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            if (shouldExit()) {
                System.out.println(Thread.currentThread().getName() + ": Exiting");
                return;
            }
            System.out.println(Thread.currentThread().getName() + ": Processing record " + i);

            Thread.sleep(1000);

        }
    }
}