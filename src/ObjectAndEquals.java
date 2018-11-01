import org.junit.Test;

public class ObjectAndEquals {
    @Test
    public void testEquals() {
        Object o = new Object();
        o.equals(o);
        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("a") + "bc";
        String s4 = new String("abc");
        String s5 = "a" + "bc";

        s1.equals(s1);

        s1.substring(0);

        System.out.println(s1 == s5);
        //Stirng hashCode()被重写
        System.out.println(Integer.toHexString(s1.hashCode()));

    }
}
