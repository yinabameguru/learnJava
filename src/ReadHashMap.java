import org.junit.Test;

import java.util.*;

public class ReadHashMap {
    @Test
    public void readHashMap() {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("a", "a");
        //表示只有当对应 key 的位置为空的时候替换元素
//        hashMap.putIfAbsent("a", "b");
        System.out.println(hashMap.get("a"));

        int num1 = 4, num2 = 7;
        System.out.println((num2 % num1) == (num2 & (num1 - 1)));

        Set<Map.Entry<String, String>> entries = hashMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            next.getKey();
            next.getValue();
        }
        HashSet hashSet = new HashSet();
//        Arrays.sort();
    }


    //计算扩容阈值
    @Test
    private void tableSizeFor() {
        int cap = 10;
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        //经过上述面的 或和位移 运算， n 最终各位都是1
    }
}
