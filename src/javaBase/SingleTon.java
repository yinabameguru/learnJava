package javaBase;

import sun.misc.Launcher;

public class SingleTon {
    private static SingleTon singleTon = new SingleTon();
    public static int count1;
    public static int count2 = 0;
    public static int count3 = 1;

    private SingleTon() {
        count1++;
        count2++;
        count3++;
    }

    public static SingleTon getInstance() {
        return singleTon;
    }
}

class Test {
    public static void main(String[] args) {
        System.out.println();
        SingleTon singleTon = SingleTon.getInstance();
        System.out.println("count1=" + singleTon.count1);
        System.out.println("count2=" + singleTon.count2);
    }

}
