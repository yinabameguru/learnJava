import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
//        ClassC c = new ClassC();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            arr.add(i);
        }
        System.out.println(arr.toString());
        for (int i = 19; i >= 0; i--) {
            arr.remove(i);
            System.out.println(arr.toString());
        }
//        arr.remove(15);
    }
}
