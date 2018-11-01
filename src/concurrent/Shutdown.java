package concurrent;

import java.util.concurrent.TimeUnit;

public class Shutdown {
    static class Runner implements Runnable {
        private int i = 0;
        private volatile boolean on = true;
        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println(i);
        }

        public void cancel() {
            on = false;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runner runner1 = new Runner();
        Thread thread1 = new Thread(runner1, "runner1");
        thread1.start();
        TimeUnit.SECONDS.sleep(2);
        thread1.interrupt();
        Runner runner2 = new Runner();
        Thread thread2 = new Thread(runner2, "runner2");
        thread2.start();
        TimeUnit.SECONDS.sleep(1);
        runner2.cancel();
    }
}
