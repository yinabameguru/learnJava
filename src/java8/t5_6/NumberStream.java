package java8.t5_6;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Test;

public class NumberStream {

    @Test
    public void numberStream() {
//        List<Integer> list = Lists.newArrayList();
//        List<Integer> list = null;
        List<Integer> list = Lists.newArrayList(1, 5, 2, 4, 3);
        int sum = list.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);
        list.stream().mapToInt(Integer::intValue).max().ifPresent(System.out::println);
        IntStream.range(0, 10).forEach(System.out::println);
        IntStream.rangeClosed(0, 10).forEach(System.out::println);

        List<int[]> ints = IntStream.rangeClosed(1, 100).boxed()
            .flatMap(i -> IntStream.rangeClosed(i, 100)
                .filter(j -> Math.sqrt(i * i + j * j) % 1 == 0)
                .mapToObj(j -> new int[]{i, j, (int) Math.sqrt(i * i + j * j)}))
            .collect(Collectors.toList());
        ints.forEach(arr -> System.out.println(Arrays.toString(arr)));
        List<double[]> doubles1 = IntStream.rangeClosed(1, 100).boxed()
            .flatMap(i -> IntStream.rangeClosed(i, 100)
                .mapToObj(j -> new double[]{i, j, Math.sqrt(i * i + j * j)})
                .filter(doubles -> doubles[2] % 1 == 0)).collect(Collectors.toList());
        doubles1.forEach(doubles -> System.out.println(Arrays.toString(doubles)));
    }

}
