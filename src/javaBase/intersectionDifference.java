package javaBase;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class intersectionDifference {

    private List<List<User>> help(List<User> a, List<User> b) {
        List<User> intersection = a.stream().filter(item -> b.stream().map(User::getUserId).anyMatch(id -> id.equals(item.getUserId()))).collect(Collectors.toList());
        List<User> Adiff = a.stream().filter(item -> b.stream().map(User::getUserId).noneMatch(id -> id.equals(item.getUserId()))).collect(Collectors.toList());
        List<User> Bdiff = b.stream().filter(item -> a.stream().map(User::getUserId).noneMatch(id -> id.equals(item.getUserId()))).collect(Collectors.toList());
        return Lists.newArrayList(intersection, Adiff, Bdiff);
    }

    public List<Set<User>> help2(List<User> a, List<User> b) {
        Set<User> users = new HashSet<>(a);
        Set<User> users2 = new HashSet<>(b);
        Set<User> intersection = Sets.intersection(users, users2);
        Set<User> Adiff = Sets.difference(users, users2);
        Set<User> Bdiff = Sets.difference(users2, users);
        return Lists.newArrayList(intersection, Adiff, Bdiff);
    }
    @Test
    public void donggetest() {
        List<User> a = Lists.newArrayList(new User(1), new User(2), new User(3));
        List<User> b = Lists.newArrayList(new User(2));
        List<Set<User>> help = help2(a, b);
        help.forEach(System.out::println);
    }
}
