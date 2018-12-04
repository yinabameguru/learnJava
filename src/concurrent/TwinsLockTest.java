package concurrent;

import java.util.concurrent.TimeUnit;
import org.junit.Test;

public class TwinsLockTest {

    TwinsLock lock = new TwinsLock();

    @Test
    public void twinsLockTest() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Worker worker = new Worker();
            Thread thread = new Thread(worker, "worker" + i);
            thread.setDaemon(true);
            thread.start();
        }
        for (int i = 0; i < 10; i++) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println();
        }
    }

    class Worker implements Runnable {

        @Override
        public void run() {
            lock.lock();
//            System.out.println(Thread.currentThread().getName() + "lock");
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
//                System.out.println(Thread.currentThread().getName() + "unlock");
            }
        }
    }

}
