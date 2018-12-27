package java8.t2_1;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java8.Apple;
import org.junit.Test;

public class PrettyPrintApple {

    //策略模式
    public <T> void prettyPrintApple(List<T> inventory, BasePrettyPrintApple<T> basePrettyPrintApple) {
        for (T t : inventory) {
            basePrettyPrintApple.print(t);
        }
    }

    @Test
    public void printTest() {
        List<Apple> apples = Lists
            .newArrayList(new Apple("red", 100), new Apple("green", 151));
        prettyPrintApple(apples, new ColorPrintApple());
        prettyPrintApple(apples, new WeightPrintApple());
        prettyPrintApple(apples, new BasePrettyPrintApple<Apple>() {
            @Override
            public void print(Apple apple) {
                System.out.println("a");
            }
        });
            prettyPrintApple(apples, apple -> System.out.println(apple.getWeight()));
        ArrayList<String> strings = Lists.newArrayList("a", "b");
        prettyPrintApple(strings, System.out::println);

        apples.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o2.getWeight().compareTo(o1.getWeight());
            }
        });
        System.out.println(apples.toString());
        apples.sort((o1, o2) -> o2.getWeight().compareTo(o1.getWeight()));
        System.out.println(apples.toString());
        apples.sort(Comparator.comparing(Apple::getWeight));
    }

}

interface BasePrettyPrintApple<T> {

    void print(T t);

}

class ColorPrintApple implements BasePrettyPrintApple<Apple> {

    @Override
    public void print(Apple apple) {
        System.out.println(apple.getColor());
    }
}

class WeightPrintApple implements BasePrettyPrintApple<Apple> {

    @Override
    public void print(Apple apple) {
        System.out.println(apple.getWeight());
    }
}