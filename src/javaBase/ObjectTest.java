package javaBase;

public class ObjectTest implements Cloneable {

    int[] i = new int[]{1};


    public ObjectTest() {
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        ObjectTest objectTest = new ObjectTest();
        ObjectTest objectTest2 = objectTest;
        ObjectTest clone =(ObjectTest)objectTest.clone();
        System.out.println(objectTest == clone);
        objectTest.i[0] = 2;
        System.out.println(objectTest.i[0]);
        System.out.println(clone.i[0]);
//        Object o = new Object();
//        System.out.println(o.toString());
//        System.out.println(o.hashCode());
    }

}
