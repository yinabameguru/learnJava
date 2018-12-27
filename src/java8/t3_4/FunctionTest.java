package java8.t3_4;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import org.junit.Test;

public class FunctionTest {

    public <T, R> List<R> replace(List<T> list, Function<T, R> function) {
        List<R> res = Lists.newArrayList();
        for (T t : list) {
            res.add(function.apply(t));
        }
        return res;
    }

    @Test
    public void functionTest() {
        ArrayList<String> list = Lists.newArrayList("a", "aa", "aaa");
        List<Integer> res = replace(list, s -> s.length());
        System.out.println(res);
    }
}
