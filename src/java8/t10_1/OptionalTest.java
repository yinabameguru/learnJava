package java8.t10_1;

import java.util.Optional;
import org.junit.Test;

public class OptionalTest {

    @Test
    public void optionalTest() {
        Insurance insurance = new Insurance("insurance");
        Car car = new Car(insurance);
        Person person = new Person(car);
        Optional<Person> person1 = Optional.of(person);
        Optional<Car> car1 = Optional.of(person).map(Person::getCar);
        Optional<Insurance> insurance1 = Optional.of(person).map(Person::getCar)
            .map(Car::getInsurance);
        Optional<String> s1 = Optional.of(person).map(Person::getCar).map(Car::getInsurance)
            .map(Insurance::getName);
        Insurance insurance2 = new Insurance("aa");
        Optional.ofNullable(person.getCar()).map(Car::getInsurance)
            .ifPresent(insurance3 -> insurance2.setName(insurance3.getName()));
        System.out.println(insurance2.getName());
    }
}

class Person {

    private Car car;

    public Person(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}

class Car {

    private Insurance insurance;

    public Car(Insurance insurance) {
        this.insurance = insurance;
    }

    public void setInsurance(Insurance insurance) {

        this.insurance = insurance;
    }

    public Insurance getInsurance() {
        return insurance;
    }
}

class Insurance {

    private String name;

    public Insurance(String name) {
        this.name = name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }
}