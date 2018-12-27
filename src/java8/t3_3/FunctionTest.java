package java8.t3_3;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class FunctionTest {

    @Test
    public void PrintTest() {
        ArrayList<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5);
        doPrint(list, list1 -> System.out.println(list.toString()));
//        Consumer<Integer> c = i -> list.add(i);
        int i = 1;
//        i = 2;
        Runnable runnable = () -> System.out.println(i);
    }
    private void doPrint(List<Integer> list, Print print) {
        print.print(list);
    }
}
@FunctionalInterface
interface Print {

    void print(List<Integer> list);
}