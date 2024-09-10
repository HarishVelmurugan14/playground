package SelfLearn.Java.Defaultpackage.Threads;

class MyRunnable implements Runnable {
    private SharedResource resource;

    public MyRunnable(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        try {
            resource.myMethod();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
