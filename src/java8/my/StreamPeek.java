package java8.my;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java8.Dish;
import org.junit.Test;

public class StreamPeek {

    @Test
    public void streamPeek() {
        List<Dish> dishes = Dish.getMenu().stream()
            .peek(dish -> dish.setName("aaa," + dish.getName())).collect(Collectors
                .toList());
        dishes.stream().forEach(System.out::println);
    }

    @Test
    public void streamToList() {
        List<Integer> integers = IntStream.rangeClosed(0, 10).boxed().filter(integer -> integer > 20)
            .collect(Collectors.toList());
        List<Object> collect = IntStream.rangeClosed(0, 10).boxed().map(integer -> null)
            .collect(Collectors.toList());
        System.out.println(integers);
        System.out.println(new ArrayList<>());
        List list = null;
        System.out.println(list);
        System.out.println(collect);
    }

}
