import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import java.util.ArrayList;

public class JoinerTest {

    public static void main(String[] args) {
        ArrayList<Integer> list = Lists.newArrayList(1, null, 3, 4, 5);
        String s = Joiner.on(",").skipNulls().join(list);
        System.out.println(s);
        String s2 = Joiner.on(",").useForNull("null").join(list);
        System.out.println(s2);
    }

}
