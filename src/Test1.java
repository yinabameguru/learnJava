import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class Test1 {
    public static void main(String[] args) {
//        ClassC c = new ClassC();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            arr.add(i);
        }
        System.out.println(arr.toString());
        for (int i = 19; i >= 0; i--) {
            arr.remove(i);
            System.out.println(arr.toString());
        }
//        arr.remove(15);
    }

    @Test
    public void test1(){
        int num1 = 0, num2 = 1;
        num1 = num2 = 2;
        System.out.println(num1 + " " + num2);
    }

}

class Test2 extends AbstractQueuedSynchronizer {

}