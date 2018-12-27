package java8.t5_4;

import java.util.Optional;
import java8.Dish;
import org.junit.Test;

public class ReduceTest {

    @Test
    public void reduceTest() {
        Integer sum = Dish.getMenu().stream().map(Dish::getCalories).reduce(0, Integer::sum);
        System.out.println(sum);
        Integer max = Dish.getMenu().stream().map(Dish::getCalories).reduce(0, Integer::max);
        System.out.println(max);
        Optional<Integer> sum2 = Dish.getMenu().stream().map(Dish::getCalories)
            .reduce(Integer::sum);
        Integer dishSum = Dish.getMenu().stream().map(dish -> 1).reduce(0, Integer::sum);
        System.out.println(dishSum);
    }

}
