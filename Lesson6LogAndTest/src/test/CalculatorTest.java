package test;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import testing.Calculator;

public class CalculatorTest {
    private static Calculator calc;

    @BeforeClass
    public static void init() {
        System.out.println("init calc");
        calc = new Calculator();
    }

//    @Test
//    public void justFail() {
//        String s;
//        Assert.fail();
//    }

    @Test
    public void testAdd() {

        Assert.assertEquals(4, calc.add(2, 2));
    }

    @Test(expected = ArithmeticException.class)
    public void testArithmeticException() {

        calc.div(10, 0);
    }

    @Test
    public void testDiv10By5() {

        Assert.assertEquals(2, calc.div(10, 5));
    }

    //@Ignore("Выключенный тест") в случае необходимости
    @Test
    public void testEmpty() {
        Assert.assertEquals(20, calc.div(100, 5));
        //Assert.fail();
    }

    @Test(timeout = 1000)
    public void testTimeout() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
