package javaBase;

import org.junit.Test;

import java.util.HashMap;

public class OverLoadTest extends father {

    int i = 2;

//    public OverLoadTest(int i) {
//        super(i);
////        this.i = i;
//    }

    public OverLoadTest() {
        super(1);
    }


    @Override
    String f() {
        System.out.println(super.i);
        return null;
    }

    @Test
    public void test() {
        f();

//        OverLoadTest overLoadTest = new OverLoadTest(1);
//        System.out.println(overLoadTest.i);
    }

    public static void main(String[] args) {
//        OverLoadTest overLoadTest = new OverLoadTest(1);
//        System.out.println(overLoadTest.i);
    }

//    Integer f() {
//        Object
//        return null;
//    }
}

abstract class father {
    int i = 0;
    abstract String f();

    public father() {
    }

    public father(int i) {
        this.i = i;
    }
}
