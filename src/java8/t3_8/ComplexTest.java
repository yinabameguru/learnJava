package java8.t3_8;

import java.util.function.Function;
import org.junit.Test;

public class ComplexTest {

    @Test
    public void complexTest() {
        Function<Integer, Integer> f = i -> i + 1;
        Function<Integer, Integer> f2 = i -> i * 2;
        Integer i = f.andThen(f2).apply(1);
        System.out.println(i);
        Integer i2 = f.compose(f2).apply(1);
        System.out.println(i2);
    }

}
