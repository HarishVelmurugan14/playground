package SelfLearn.Java.Defaultpackage.Threads;

public class DriverClass {
    public static void main(String[] args) throws InterruptedException {
        SharedResource resource = new SharedResource();

        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            Thread.sleep(1000);
            threads[i] = new Thread(new MyRunnable(resource));
            threads[i].start();
        }

        try {
            Thread.sleep(3000);
            resource.setExit();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
