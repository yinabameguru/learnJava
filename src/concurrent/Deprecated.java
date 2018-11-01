package concurrent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Deprecated {
    static class Runner implements Runnable {

        @Override
        public void run() {
            SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
            while (true) {
                System.out.println(Thread.currentThread().getName() + " " + format.format(new Date()));
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread runner = new Thread(new Runner(), "runner");
        runner.setDaemon(true);
        runner.start();
        TimeUnit.SECONDS.sleep(3);
        runner.suspend();
        TimeUnit.SECONDS.sleep(3);
        runner.resume();
        TimeUnit.SECONDS.sleep(3);
        runner.stop();
        TimeUnit.SECONDS.sleep(3);
    }
}
