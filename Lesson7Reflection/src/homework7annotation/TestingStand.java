package homework7annotation;
//Малыгин Андрей, домашнее задание к 7 уроку Java3.
import java.lang.reflect.Method;

public class TestingStand {
    public static void main(String[] args) {
        timeStart();
        start();
        timeFinish();
    }

    public static void start() {
        Method[] methods = SimpleTest.class.getDeclaredMethods();
        for (Method m : methods) {
            if (m.getAnnotation(Test.class) != null){
                System.out.println(m);
            }
        }
    }

    @BeforeSuite(before = "время начала теста")
    public static void timeStart(){
        System.out.println("начали тест");
    }

    @AfterSuite(after = "время окончания теста")
    public static void timeFinish(){
        System.out.println("закончили тест");
    }

}
