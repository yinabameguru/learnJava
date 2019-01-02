package java8.t6_2;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java8.Dish;
import org.junit.Test;

public class CollectorTest {

    @Test
    public void collectorTest() {
        long count = Dish.getMenu().stream().count();
        Dish.getMenu().size();
        Dish.getMenu().stream().collect(Collectors.maxBy(Comparator.comparing(Dish::getCalories)));
        Dish.getMenu().stream().max(Comparator.comparing(Dish::getCalories));
        Dish.getMenu().stream().collect(Collectors.summingInt(Dish::getCalories));
        Dish.getMenu().stream().mapToInt(Dish::getCalories).sum();
        Dish.getMenu().stream().collect(Collectors.averagingInt(Dish::getCalories));
        IntSummaryStatistics intSummaryStatistics = Dish.getMenu().stream()
            .collect(Collectors.summarizingInt(Dish::getCalories));
        System.out.println(intSummaryStatistics);
        String s = Dish.getMenu().stream().map(Dish::getName).collect(Collectors.joining(", "));
        System.out.println(s);
//        Dish.getMenu().stream().collect(Collectors.joining())
        Dish.getMenu().stream().collect(Collectors.reducing(0, Dish::getCalories, (u, u2) -> u + u2));
        Dish.getMenu().stream().map(Dish::getCalories).reduce(0, (u, u2) -> u + u2);
        Dish.getMenu().stream().collect(Collectors.reducing((o, o2) -> o.getCalories() > o2.getCalories() ? o : o2));
        Dish.getMenu().stream().reduce((o, o2) -> o.getCalories() > o2.getCalories() ? o : o2);

    }

}
