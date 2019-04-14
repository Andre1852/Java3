package test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import testing.MyCalc;

public class MyCalcTest {
    private static MyCalc mycalc;

    @BeforeClass
    public static void initTest() {
        mycalc = new MyCalc();
        System.out.println("init suite");
    }

    @Test
    public void testAdd() {
        Assert.assertEquals(7, mycalc.add(3, 4));
    }

    @Test
    public void testAdd2() {
        Assert.assertEquals(0, mycalc.add(0, 0));
    }

    @Test
    public void testSub() {
        Assert.assertEquals(6, mycalc.sub(9, 3));
    }

    @Test
    public void testDiv() {
        Assert.assertEquals(3, mycalc.div(9, 3));
    }

    @Test
    public void testMul() {
        Assert.assertEquals(27, mycalc.mul(9, 3));
    }

    @Test(expected = ArithmeticException.class)
    public void testDivBy0() {
        mycalc.div(10, 0);
    }

    @Rule
    public final Timeout timeout = new Timeout(1000);

    @Test(timeout = 200)
    public void testVeryFastMethod() {
        mycalc.add(10, 10);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
