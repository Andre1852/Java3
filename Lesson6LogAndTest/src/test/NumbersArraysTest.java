package test;
//Малыгин Андрей, домашнее задание к 6 уроку Java3.
import homework6test.NumbersArrays;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class NumbersArraysTest {
    private static int[] numbersArray = {1, 2, 3, 1, 0, 7, 8, 0, 2, 1, 7};

    private static NumbersArrays numbArr;

    @BeforeClass
    public static void initial(){
        System.out.println("размер измененного массива совпадает с ожидаемым");
        numbArr = new NumbersArrays();

    }

    @Test
    public void testTransform() {
        Assert.assertEquals(-1, numbArr.transform(numbersArray));
    }
}
