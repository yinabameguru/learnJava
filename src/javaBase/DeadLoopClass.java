package javaBase;

public class DeadLoopClass {
    static DeadLoopClass deadLoopClass = new DeadLoopClass();
    public static int i1 = 1;

    public DeadLoopClass() {
        if (true) {
            System.out.println("init");
            while (true) {

            }
        }
        i1 = 2;
    }

    public static DeadLoopClass get() {
        return deadLoopClass;
    }
}

class test {
    public static void main(String[] args) {
        System.out.println(DeadLoopClass.get().i1);
    }
}
