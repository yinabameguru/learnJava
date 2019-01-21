package java8.t13_2;

import com.google.common.collect.Lists;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;

public class Subset {

    public List<List<Integer>> subset(List<Integer> list) {
        if (list.size() == 0) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(Collections.emptyList());
            return ans;
        }
        Integer first = list.get(0);
        List<Integer> subList = list.subList(1, list.size());
        List<List<Integer>> subset = subset(subList);

//        List<List<Integer>> lists = subset.stream().peek(l -> l.add(first))
//            .collect(Collectors.toList());
//        subset.addAll(lists);
        return subset;
    }

    @Test
    public void subSetTest() {
        List<List<Integer>> subset = subset(Lists.newArrayList(1, 4, 9));
        System.out.println();
    }
}
