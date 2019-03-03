package javaBase;

import org.junit.Test;

import java.util.ArrayList;

public class JavaValueTransfer {
    @Test
    public void test() {
        Object o = new Object();
        System.out.println(o);
        f(o);
    }

    public void f(Object o) {
        System.out.println(o);
        o = new Object();
        System.out.println(o);
    }
}
