package java8.t13_2;

import com.google.common.collect.Lists;
import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

public class Subset {

    public List<List<Integer>> subset(List<Integer> list) {
        if (list.size() == 0) {
            return Lists.newArrayList();
        }
        Integer first = list.get(0);
        List<Integer> subList = list.subList(1, list.size() - 1);
        List<List<Integer>> subset = subset(subList);
        List<List<Integer>> lists = subset.stream().peek(l -> l.add(first))
            .collect(Collectors.toList());
        // TODO: 2019/1/16
        return null;
    }


}
