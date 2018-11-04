package concurrent;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class DefaultThreadPool2<Job extends Runnable> implements ThreadPool<Job> {
    private static final int DEFAULT_SIZE = 10;
    private static final int MAX_SIZE = 30;
    private final Queue<Job> jobs = new LinkedList<>();
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<>());
    private AtomicInteger threadNum = new AtomicInteger();

    public DefaultThreadPool2(int threadNum) {
        init(threadNum);
    }

    public DefaultThreadPool2() {
        init(DEFAULT_SIZE);
    }

    private void init(int num) {
        synchronized (jobs) {
            for (int i = 0; i < num; i++) {
                Worker worker = new Worker();
                workers.add(worker);
                new Thread(worker, "thread-worker-" + threadNum.incrementAndGet()).start();
            }
        }
    }

    class Worker implements Runnable {
        private volatile boolean running = true;

        @Override
        public void run() {
            while (running) {
                Job job = null;
                synchronized (jobs) {
                    while (jobs.isEmpty()) {
                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            e.printStackTrace();
                        }
                        job = jobs.poll();
                    }
                }
                try {
                    job.run();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public void shutdown() {
            running = false;
        }

    }

    @Override
    public void execute(Job job) {
        if (job != null) {
            synchronized (jobs) {
                jobs.offer(job);
                jobs.notify();
            }
        }
    }

    @Override
    public void shutdown() {
        for (Worker worker : workers) {
            worker.shutdown();
        }
    }

    @Override
    public void addWorkers(int i) {
        synchronized (jobs) {
            int ordSize;
            int add = i + (ordSize = threadNum.intValue()) > MAX_SIZE ? MAX_SIZE : i + ordSize;
            init(add - ordSize);
        }
    }

    @Override
    public void removeWorkers(int i) {
        int ordSize;
        int rem = i > (ordSize = workers.size()) ? ordSize : i;
        for (int j = rem - 1; j >= 0; j--) {
            Worker worker = workers.remove(j);
            worker.shutdown();
            int num = threadNum.getAndDecrement();
            System.out.println("thread-worker-" + num + " has been removed" + " threadNum = " + threadNum);
        }
    }

    @Override
    public int getJobSize() {
        return jobs.size();
    }
}
