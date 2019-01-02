package java8.t6_4;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Test;

public class Prime {

    @Test
    public void primeTest() {
        int end = 100;
        Map<Boolean, List<Integer>> map = IntStream.rangeClosed(1, end).boxed()
            .collect(Collectors.partitioningBy(this::isPrime));
        System.out.println(map.get(false));
        System.out.println(map.get(true));
    }

    public boolean isPrime(Integer now) {
        return IntStream.range(2, now).noneMatch(i -> now % i == 0);
    }

}
