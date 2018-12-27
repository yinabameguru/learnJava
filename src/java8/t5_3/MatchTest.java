package java8.t5_3;

import java8.Dish;
import org.junit.Test;

public class MatchTest {

    @Test
    public void matchTest() {
        if (Dish.getMenu().stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("have vegetarian");
        }
        if (Dish.getMenu().stream().allMatch(Dish::isVegetarian)) {
            System.out.println("all vegetarian");
        }
        if (Dish.getMenu().stream().noneMatch(Dish::isVegetarian)) {
            System.out.println("none vegetarian");
        }
        Dish.getMenu().stream().filter(Dish::isVegetarian).findAny().ifPresent(System.out::println);
        Dish.getMenu().stream().filter(Dish::isVegetarian).findFirst().ifPresent(System.out::println);
    }

}
