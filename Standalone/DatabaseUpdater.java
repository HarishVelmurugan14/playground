package Standalone;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DatabaseUpdater {

    private static final Lock updateLock = new ReentrantLock();
    private static final int TOTAL_RECORDS = 100;
    private static final int THREAD_COUNT = 5;

    public static void main(String[] args) {
        // Create an array of records
        Record[] records = createInitialRecords(TOTAL_RECORDS);

        // Create five threads to update the records
        for (int i = 1; i <= THREAD_COUNT; i++) {
            final int threadId = i;
            Thread thread = new Thread(() -> updateDatabase(threadId, records));
            thread.start();
        }
    }

    private static Record[] createInitialRecords(int count) {
        Record[] records = new Record[count];
        for (int i = 0; i < count; i++) {
            records[i] = new Record(i, "Initial Status");
        }
        return records;
    }

    private static void updateDatabase(int threadId, Record[] records) {
        int batchSize = TOTAL_RECORDS / THREAD_COUNT;
        int startIndex = (threadId - 1) * batchSize;
        int endIndex = Math.min(startIndex + batchSize, TOTAL_RECORDS);

        for (int i = startIndex; i < endIndex; i++) {
            updateLock.lock();

            try {
                Record record = records[i];
                System.out.println("Thread " + threadId + " is updating Record " + record.getId());

                // Simulate some work
                Thread.sleep(1000);

                // Update the record's status
                record.setStatus("Updated by Thread " + threadId);

                System.out.println("Thread " + threadId + " updated Record " + record.getId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                updateLock.unlock();
            }
        }
    }

    static class Record {
        private int id;
        private String status;

        public Record(int id, String status) {
            this.id = id;
            this.status = status;
        }

        public int getId() {
            return id;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
