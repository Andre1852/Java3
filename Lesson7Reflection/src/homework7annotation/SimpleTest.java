package homework7annotation;
//Малыгин Андрей, домашнее задание к 7 уроку Java3.
public class SimpleTest {
    @Test(name = "тест на время")
    public void passedTest(){
        System.out.println("тест выполнен");
    }

    @Test(name = "тест на время")
    public void failedTest(){
        System.out.println("тест провален");
    }

    public void names(){
        System.out.println("тестирование проводил Петров В.Ф.");
    }


}
