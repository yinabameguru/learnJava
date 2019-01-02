package java8.t5_7;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.Test;

public class ConstructStream {

    @Test
    public void constructStream() {
        //数组流
//        int[] arr = new int[]{1, 2, 3};
//        IntStream stream = Arrays.stream(arr);
        //文件流
        try (Stream<String> lines = Files
            .lines(Paths.get("D:/workspace/learnJava/src/data.txt"), Charset.defaultCharset())) {
            List<String> list = lines.flatMap(line -> Arrays.stream(line.split(" "))).distinct()
                .collect(Collectors.toList());
            list.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //无限流
        //溢出
//        Stream.iterate(0, i -> i + 1000000).forEach(System.out::println);
        List<int[]> fibonacci = Stream
            .iterate(new int[]{0, 1}, arr -> new int[]{arr[1], arr[0] + arr[1]}).limit(20)
            .collect(Collectors.toList());
        fibonacci.forEach(arr -> System.out.println(Arrays.toString(arr)));
//        Stream.generate(Math::random).forEach(System.out::println)

    }


}
