package java8.t7_1;

import com.google.common.primitives.Longs;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import org.junit.Test;

public class Sum {

    @Test
    public void sum() {
        long perf = measureSumPerf(l -> LongStream.rangeClosed(0L, l).sum(), 10_000_000);
        System.out.println(perf);
        long perf1 = measureSumPerf(l -> LongStream.rangeClosed(0L, l).parallel().sum(), 10_000_000);
        System.out.println(perf1);
    }
    public long measureSumPerf(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
//            System.out.println("Result: " + sum);
            if (duration < fastest) fastest = duration;
        }
        return fastest;
    }
}
