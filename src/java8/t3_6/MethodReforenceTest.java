package java8.t3_6;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import org.junit.Test;

public class MethodReforenceTest {

    @Test
    public void methodReforenceTest() {
        Function<String, Integer> f = (String s) -> Integer.valueOf(s);
        Function<String, Integer> f2 = Integer::valueOf;
        BiPredicate<List<String>, String> contains = (list, element) -> list.contains(element);
        BiPredicate<List<String>, String> contains2 = List::contains;
    }

}
