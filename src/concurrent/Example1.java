package concurrent;

public class Example1 {
    int a = 0;
    boolean flag = false;

    public void writer() {
        a = 1;
        flag = true;
    }

    public void reader() {
        if (flag) {
            int i = a * a;
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        Example1 e = new Example1();
        new Thread(() -> {
            e.writer();
        }).start();
        new Thread(() -> {
            e.reader();
        }).start();
    }

}
