package java8.t5_1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java8.Dish;
import java8.Dish.Type;
import org.junit.Test;

public class StreamTest {

    @Test
    public void streamTest() {
        List<Dish> menu = Dish.getMenu();
        List<Dish> dishes = menu.stream().filter(dish -> dish.getType().equals(Type.MEAT)).limit(2)
            .collect(Collectors.toList());
        System.out.println(dishes.toString());
        List<Integer> dishNameLengths = dishes.stream().map(Dish::getName).map(String::length)
            .collect(Collectors.toList());
        System.out.println(dishNameLengths.toString());
        List<String[]> dishNameSplit = dishes.stream().map(Dish::getName).map(s -> s.split("")).distinct()
            .collect(Collectors.toList());
        System.out.println(dishNameSplit.toString());
        List<String> dishNameSplit2 = dishes.stream().map(Dish::getName).map(s -> s.split(""))
            .flatMap(Arrays::stream).distinct().collect(Collectors.toList());
        System.out.println(dishNameSplit2.toString());
        List<Integer> calories = menu.stream().map(dish -> dish.getCalories() * dish.getCalories())
            .collect(Collectors.toList());
        System.out.println(calories);
        List<Integer[]> caloriesMap = menu.stream().map(Dish::getCalories)
            .flatMap(i -> menu.stream().map(Dish::getCalories).map(j -> new Integer[]{i, j}))
            .filter(integers -> (integers[0] + integers[1]) % 3 == 0).collect(Collectors.toList());
        caloriesMap.forEach(integers -> System.out.println(Arrays.toString(integers)));
    }

}
