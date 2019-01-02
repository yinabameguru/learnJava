package java8.t6_3;

import com.sun.jndi.url.dns.dnsURLContext;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java8.Dish;
import java8.Dish.Type;
import org.junit.Test;

public class GroupingTest {

    @Test
    public void groupingTest() {
        Map<Type, List<Dish>> map = Dish.getMenu().stream()
            .collect(Collectors.groupingBy(Dish::getType));
        System.out.println(map.toString());

        Map<String, List<Dish>> map1 = Dish.getMenu().stream()
            .collect(Collectors.groupingBy(d -> {
                if (d.getCalories() > 500) {
                    return "high";
                }
                return "low";
            }));
        System.out.println(map1.toString());

        Map<Type, Map<String, List<Dish>>> map2 = Dish.getMenu().stream()
            .collect(Collectors.groupingBy(Dish::getType, Collectors.groupingBy(
                d -> {
                    if (d.getCalories() > 500) {
                        return "high";
                    }
                    return "low";
                }
            )));
        System.out.println(map2.toString());
        Map<Type, Long> map3 = Dish.getMenu().stream()
            .collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
        System.out.println(map3);
        Map<Type, Optional<Dish>> map4 = Dish.getMenu().stream().collect(Collectors
            .groupingBy(Dish::getType,
                Collectors.maxBy(Comparator.comparingInt(Dish::getCalories))));
        System.out.println(map4);
        Map<Type, Dish> map5 = Dish.getMenu().stream().collect(Collectors
            .groupingBy(Dish::getType, Collectors
                .collectingAndThen(Collectors.maxBy(Comparator.comparing(Dish::getCalories)),
                    Optional::get)));
        System.out.println(map5);
        Map<Type, Set<String>> map6 = Dish.getMenu().stream()
            .collect(Collectors.groupingBy(Dish::getType, Collectors.mapping(
                d -> {
                    if (d.getCalories() > 500) {
                        return "high";
                    }
                    return "low";
                }, Collectors.toSet()
            )));
        System.out.println(map6);
        Map<Type, Set<String>> map7 = Dish.getMenu().stream()
            .collect(Collectors.groupingBy(Dish::getType, Collectors.mapping(
                d -> {
                    if (d.getCalories() > 500) {
                        return "high";
                    }
                    return "low";
                }, Collectors.toCollection(HashSet::new)
            )));
        System.out.println(map7);
        Map<Boolean, List<Dish>> map8 = Dish.getMenu().stream()
            .collect(Collectors.partitioningBy(Dish::isVegetarian));
        System.out.println(map8);
        Map<Boolean, Map<String, List<Dish>>> map9 = Dish.getMenu().stream()
            .collect(Collectors.partitioningBy(Dish::isVegetarian, Collectors.groupingBy(d -> {
                if (d.getCalories() > 500) {
                    return "high";
                } else {
                    return "low";
                }
            })));
        System.out.println(map9);
        Map<Boolean, Map<Type, List<Dish>>> map10 = Dish.getMenu().stream().collect(
            Collectors.partitioningBy(Dish::isVegetarian, Collectors.groupingBy(Dish::getType)));
        System.out.println(map10);
        Map<Boolean, Map<Boolean, List<Dish>>> map11 = Dish.getMenu().stream().collect(
            Collectors.partitioningBy(Dish::isVegetarian,
                Collectors.partitioningBy(d -> d.getCalories() > 500)));
        System.out.println(map11);
        Map<Boolean, Map<Boolean, Long>> map12 = Dish.getMenu().stream()
            .collect(Collectors.partitioningBy(Dish::isVegetarian,
                Collectors.partitioningBy(d -> d.getCalories() > 500, Collectors.counting())));
        System.out.println(map12);
    }

}
