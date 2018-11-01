package concurrent;

public class VolatileFeaturesExample {
    volatile long vl = 0;

    public void increment() {
        vl++;
    }

    public synchronized void increment2() {
        vl++;
    }

    public static void main(String[] args) {
        VolatileFeaturesExample ve = new VolatileFeaturesExample();

        //不安全
        Runnable runnable = () -> {
            for (int i = 0; i < 100; i++) {
                ve.increment();
            }
            System.out.println(ve.vl);
        };

        Runnable runnable2 = () -> {
            for (int i = 0; i < 100; i++) {
                ve.increment2();
            }
            System.out.println(ve.vl);
        };
        for (int i = 0; i < 10; i++) {
            new Thread(runnable2).start();
        }
    }
}
