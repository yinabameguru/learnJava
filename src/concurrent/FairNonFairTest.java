package concurrent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import org.junit.Test;

public class FairNonFairTest {

    ReentrantLock2 lock;

    @Test
    public void fairTest() throws InterruptedException {
        lock = new ReentrantLock2(true);
        for (int i = 0; i < 5; i++) {
            Job job = new Job(lock);
            job.start();
        }
        TimeUnit.SECONDS.sleep(15);
    }

    @Test
    public void NonFairTest() throws InterruptedException {
        lock = new ReentrantLock2(false);
        for (int i = 0; i < 5; i++) {
            Job job = new Job(this.lock);
            job.start();
        }
        TimeUnit.SECONDS.sleep(15);
    }

    class Job extends Thread {

        ReentrantLock2 lock;

        public Job(ReentrantLock2 lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    System.out.println(
                        Thread.currentThread().getName() + ",  " + lock.getQueuedthreads());
                    System.out.println();
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class ReentrantLock2 extends ReentrantLock {

        public ReentrantLock2(boolean fair) {
            super(fair);
        }

        public List<Thread> getQueuedthreads() {
            Collection<Thread> queuedThreads = super.getQueuedThreads();
            List<Thread> threads = new ArrayList<>(queuedThreads);
            Collections.reverse(threads);
            return threads;
        }
    }
}
