package test;
//Малыгин Андрей, домашнее задание к 6 уроку Java3.
import homework6test.ArrayStructure;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import java.util.Arrays;
import java.util.Collection;

//Малыгин Андрей, домашнее задание к 6 уроку Java3.
@RunWith(value = Parameterized.class)
public class ArrayStructureTest {
    private static ArrayStructure structure = null;
    private int[] arr;
    private boolean resBool;

    public ArrayStructureTest(int[] arr, boolean resBool) {
        this.arr = arr;
        this.resBool = resBool;
    }
    @Parameterized.Parameters
    public static Collection abracadabra2() {
        return Arrays.asList(
                new Object[][]{
                        {1, 2, 3, 4, true},
                        {5, 5, 5, 5, false}
                }
        );
    }
    @Test
    public void boolTest() {
        Assert.assertEquals(structure.structureCheck(arr), resBool);
    }
    @Before
    public void init() {
        System.out.println("init calc");
        structure = new ArrayStructure();
    }

    @After
    public void tearDown() throws Exception {
        structure = null;
    }
}
