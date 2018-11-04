package concurrent;


import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {
    private static final int MAX_WORKER_NUMBER = 20;
    private static final int MIN_WORKER_NUMBER = 1;
    private static final int DEFAULT_WORKER_NUMBER = 5;
    private final Queue<Job> jobs = new LinkedList<>();
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<>());
    private int workerNum = DEFAULT_WORKER_NUMBER;
    private AtomicInteger threadNum = new AtomicInteger();

    public DefaultThreadPool(int workerNum) {
        this.workerNum = workerNum;
        init(workerNum);
    }

    public DefaultThreadPool() {
        init(DEFAULT_WORKER_NUMBER);
    }

    private void init(int workerNum) {
        for (int i = 0; i < workerNum; i++) {
            Worker worker = new Worker();
            String name;
            workers.add(worker);
            Thread thread = new Thread(worker, (name = "thread-worker-" + threadNum.incrementAndGet()));
            System.out.println(name + " started");
            thread.start();
        }
    }

    @Override
    public void execute(Job job) {
        if (job != null) {
            synchronized (jobs) {
                jobs.add(job);
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
            int add = i + (ordSize = workers.size()) > MAX_WORKER_NUMBER ? add = MAX_WORKER_NUMBER : i + ordSize;
            for (int j = ordSize; j < add; j++) {
                Worker worker = new Worker();
                String name;
                Thread thread = new Thread(worker, (name = "thread-worker-" + threadNum.incrementAndGet()));
                System.out.println(name + " started" + " threadNum = " + threadNum);
                thread.start();
                workers.add(worker);
            }
        }
    }

    @Override
    public void removeWorkers(int i) {
        synchronized (jobs) {
            int ordSize;
            int rem = i > (ordSize = workers.size()) ? ordSize : i;
            for (int j = rem - 1; j >= 0; j--) {
                Worker worker = workers.remove(j);
                worker.shutdown();
                int num = threadNum.getAndDecrement();
                System.out.println("thread-worker-" + num + " has been removed" + " threadNum = " + threadNum);
            }
        }
    }

    @Override
    public int getJobSize() {
        return jobs.size();
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
                    }
                    job = jobs.poll();
                }
                if (job != null) {
                    try {
                        job.run();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public void shutdown() {
            running = false;
        }
    }

    static class Runner implements Runnable {
        long remaining;
        String name;

        public Runner(long remaining, String name) {
            this.remaining = remaining;
            this.name = name;
        }

        @Override
        public void run() {
            long future = System.currentTimeMillis() + remaining;
            int i = 0;
            while (future > System.currentTimeMillis()) {
                System.out.println(name + " " + ++i);
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        DefaultThreadPool<Runnable> pool = new DefaultThreadPool<>(10);
        TimeUnit.SECONDS.sleep(1);
//        System.out.println(pool.workers.size());
//        TimeUnit.SECONDS.sleep(1);
//        pool.addWorkers(3);
//        System.out.println(pool.workers.size());
//        TimeUnit.SECONDS.sleep(1);
//        pool.removeWorkers(3);
//        System.out.println(pool.workers.size());
//        System.out.println(pool.getJobSize());

        for (int i = 0; i < 10; i++) {
            pool.execute(new Runner(5000, "runner-" + (i + 1)));
        }
}

}
