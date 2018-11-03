package concurrent;

public class TimeoutWaiting {
    private static volatile Integer i = 0;
    static class Print implements Runnable {
        long remaining;

        public Print(long remaining) {
            this.remaining = remaining;
        }

        @Override
        public void run() {
            long future = System.currentTimeMillis() + remaining;
            while (true && future > System.currentTimeMillis()) {
                synchronized (i) {
                System.out.println(i++);
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Print(2000)).start();
    }

}
