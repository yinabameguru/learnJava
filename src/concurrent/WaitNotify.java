package concurrent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class WaitNotify {
    static boolean flag = true;
    static Object o = new Object();
    static class Wait implements Runnable {
        @Override
        public void run() {
            synchronized (o) {
                while (flag) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " is going to waiting " + " flag = " + flag +
                                new SimpleDateFormat("hh:mm:ss").format(new Date()));
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(Thread.currentThread().getName() + " notified " + " flag = " + flag +
                        new SimpleDateFormat("hh:mm:ss").format(new Date()));
            }
        }
    }

    static class Notify implements Runnable {
        @Override
        public void run() {
            synchronized (o) {
                System.out.println(Thread.currentThread().getName() + " is going to notifying" +
                        new SimpleDateFormat("hh:mm:ss").format(new Date()));
                flag = false;
                o.notifyAll();
                System.out.println(Thread.currentThread().getName() + " sleep" +
                        new SimpleDateFormat("hh:mm:ss").format(new Date()));
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o) {
                System.out.println(Thread.currentThread().getName() + " get lock" +
                        new SimpleDateFormat("hh:mm:ss").format(new Date()));
                System.out.println(Thread.currentThread().getName() + " sleep" +
                        new SimpleDateFormat("hh:mm:ss").format(new Date()));
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Wait(), "waitThread").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(new Notify(), "notifyThread").start();
    }

}
