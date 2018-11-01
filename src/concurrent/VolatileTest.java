package concurrent;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.LinkedTransferQueue;

public class VolatileTest {
    @Test
    public void volatileTest() {
        LinkedTransferQueue<Integer> queue = new LinkedTransferQueue<>();

    }

    @Test
    public void test1() {

        int nNum = 25,nSum=0;
        int nMid =5;
        while(nNum>=nMid)    //统计nNum!前能分解出5的个数，注意25能分解出两个
        {
            nSum += (nNum / nMid);
            nMid*=5;
        }
        System.out.println(nSum);
    }

    @Test
    public void test2() {
        int a = 25;
        int count = 0;
        for (; ;) {
            a = a/5;
            if (a == 0) {
                break;
            }else {
                count+= a;
            }
        }
        System.out.println("阶乘结果后面的零的个数为:"+count);
    }

    @Test
    public void test3() {
        int num1 = 1000, num2 = 5, count = 0;
        while (num1 >= num2) {
            count = count + num1 / num2;
            num2 = num2 * 5;
        }
        System.out.println(count);
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat();
        String s = df.format(date);
        System.out.println(s);
    }
}
