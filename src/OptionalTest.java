import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {
//        Optional<User> empty = Optional.empty();
//        User user = empty.get();

//        User user = null;
//        Optional<User> optional = Optional.of(user);
//        Optional<User> optional1 = Optional.ofNullable(user);

//        User nUser = null;
//        User user = new User(1L, "jza", 21);
//        Optional<User> of = Optional.of(user);
//        Optional<User> ofn = Optional.ofNullable(user);
//        user = ofn.get();
//        ofn.ifPresent(user1 -> {});

//        User nUser = null;
//        User user = new User(1L, "jza", 21);
//        User user1 = Optional.ofNullable(nUser).orElseGet(() -> user);

        User nUser = null;
        User user = new User(1L, "jza", 21);
        Optional<String> optional = Optional.ofNullable(nUser).map(user1 -> user1.getName());
//        Optional.ofNullable(nUser).flatMap(user1 -> user1.getName())


    }
}

class User {

    private Long id;
    private String name;
    private Integer age;

    public User(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
