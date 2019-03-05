package javaBase;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class ReflectTest extends AbstractReflectTest{
    @Test
    public void test() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //获取Class类
        Class<?> hashMap = Class.forName("java.util.HashMap");
        Class<HashMap> hashMapClass = HashMap.class;
        Class<? extends HashMap> aClass = new HashMap().getClass();
        Map<String, String> hashMap1 = new HashMap<>();
        //判断hashMap1是不是HashMap
        System.out.println(hashMapClass.isInstance(hashMap1));
        //利用反射创建对象的两种方法
        HashMap hashMap2 = hashMapClass.newInstance();
        Constructor<HashMap> constructor = hashMapClass.getConstructor(int.class);
        HashMap hashMap3 = constructor.newInstance(64);
        //利用反射获取所有public方法
        //类
        Method[] methods = ReflectTest.class.getMethods();
        Arrays.stream(methods).forEach(System.out::println);
        System.out.println("------");
        //接口
        Method[] methods1 = Map.class.getMethods();
        Arrays.stream(methods1).forEach(System.out::println);
        System.out.println("------");
        //利用反射获取类或接口的方法（包括public、default、protected、private）但不包括继承的方法。
        Method[] declaredMethods = ReflectTest.class.getDeclaredMethods();
        Arrays.stream(declaredMethods).forEach(System.out::println);
        System.out.println("------");
        //利用反射获取构造器
        Constructor<?>[] constructors = AbstractReflectTest.class.getConstructors();
        Arrays.stream(constructors).forEach(System.out::println);
        System.out.println("------");
        //获取类的成员变量信息（和方法相同）
        Field[] fields = AbstractReflectTest.class.getFields();
        Arrays.stream(fields).forEach(System.out::println);
        System.out.println("------");
        Field[] declaredFields = AbstractReflectTest.class.getDeclaredFields();
        Arrays.stream(declaredFields).forEach(System.out::println);
        System.out.println("------");
        //利用反射调用方法
        Object f2 = AbstractReflectTest.class.getMethod("f2").invoke(ReflectTest.class.newInstance());
        System.out.println(f2);


    }

    @Override
    public void f() {

    }
}

    abstract class AbstractReflectTest implements InterfaceTest {
        public int i1 = 0;
        private int i2 = 1;
        public int f2() {
            return i2;
        }

        private void f3() {

        }

        public AbstractReflectTest(int i1, int i2) {
            this.i1 = i1;
            this.i2 = i2;
        }

        public AbstractReflectTest() {

        }

        public AbstractReflectTest(int i1) {
            this.i1 = i1;
        }
    }
