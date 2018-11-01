public class ClassC {
    static int a = 0;
    static int[] arr = new int[10];

    public static void f() {

    }

    public ClassC() {
        System.out.println("outC");
    }

    public static class ClassCInner {
        public static void fun() {
            System.out.println("innerF");
        }

        public ClassCInner() {
            System.out.println("innerC");
        }
    }


}
