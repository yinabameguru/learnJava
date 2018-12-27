package java8;

import org.junit.Test;

public interface ApplePredicate {

    public boolean test(Apple apple);

}

class GreenApplePredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}

class HeavyApplePredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return 150 > apple.getWeight();
    }
}
class AppleTest {

    @Test
    public void preducateTest() {
        Apple apple = new Apple("green", 151);

    }
}