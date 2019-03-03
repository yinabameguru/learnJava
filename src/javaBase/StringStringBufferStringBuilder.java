package javaBase;

import org.junit.Test;

public class StringStringBufferStringBuilder {

    @Test
    public void test() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();
//        public synchronized StringBuffer append()
//        stringBuffer.append()
//        public StringBuilder append()
//        stringBuilder.append()
        String s1 = new String("a");
        String s2 = new String("a");
        String s3 = s1.intern();
        String s4 = s2.intern();
        String s5 = "a";
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s3 == s4);
        System.out.println(s5 == s1);
        System.out.println(s5 == s3);
    }
}
