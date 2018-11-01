import org.junit.Test;

public class InnerClass {
    @Test
    public void InnerClassTest() {
        MainExample mainExample = new MainExample();
        System.out.println(mainExample.name());
        System.out.println(mainExample.age());
        //内部类创建方法1
        mainExample.new Test3();
        //内部类创建方法2
        new MainExample().new Test3();
        new OuterClass().testFunctionClass();
    }
}

class ClassA {
    public String name(){
        return "liutao";
    }
    public String doSomeThing(){
        // doSomeThing
        return null;
    }
}

class ClassB {
    public int age(){
        return 25;
    }
}

class MainExample{
    private class Test1 extends ClassA{

    }
    private class Test2 extends ClassB{
        public int age(){
            return super.age() + 1;
        }
    }

    public class Test3 extends ClassB{

    }
    public String name(){
        return new Test1().name();
    }
    public int age(){
        return new Test2().age();
    }
}

class OuterClass {
    int a = 1;
    static int b = 2;

    class NotStaticInnerClass {
        public void sout() {
            System.out.println(a);
            System.out.println(b);
        }
            //Inner classes cannot have static declarations
/**         public static void staticSout() {
            System.out.println(a);
            System.out.println(b);
        }
 **/
    }

    static class StaticInnerClass {
        public void sout() {
            //Non-static field 'a' cannot be referenced from a static context
//            System.out.println(a);
            System.out.println(b);
        }

        public static void staticSout() {
//            System.out.println(a);
            System.out.println(b);
        }

    }

    public void testFunctionClass() {
        class FunctionClass {
            private void fun() {
                System.out.println(a);
                System.out.println(b);
                a++;
                b++;
            }
        }
        FunctionClass functionClass = new FunctionClass();
        functionClass.fun();
    }
}