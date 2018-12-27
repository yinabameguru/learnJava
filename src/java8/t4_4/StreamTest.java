package java8.t4_4;

import java.util.List;
import java8.Dish;
import org.junit.Test;

public class StreamTest {

    @Test
    public void streamTest() {
        List<Dish> menu = Dish.getMenu();
        menu.stream().forEach(System.out::println);
        long count = menu.stream().filter(dish -> dish.getCalories() > 400).count();
        System.out.println(count);
    }

}
