package concurrent;

public class Join {
    static class Domino implements Runnable {
        Thread thread;
        public Domino(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
                System.out.println(thread.currentThread().getName() + " terminate");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread previous = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Domino(previous), "thread" + i);
            thread.start();
            previous = thread;
        }
        System.out.println(Thread.currentThread().getName() + " terminate");
    }
}
