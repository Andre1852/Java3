package homework6test;
//Малыгин Андрей, домашнее задание к 6 уроку Java3.
import java.util.ArrayList;
import java.util.List;

public class NumbersArrays {
    List<Integer> transformArray = new ArrayList<>();
    private static int x;
    private static int value;

    public int transform(int[] numbersArray){
        for (int i = 0; i < numbersArray.length; i++) {
            if (numbersArray[i] == 4) {
                x = i;
                value = numbersArray[i];
            }
        }
        if (value != 4){
            System.out.println("Массив не подходит, нет элементов со значением 4.");
            return -1;
        }
        for (int i = x + 1; i < numbersArray.length; i++) {
           transformArray.add(numbersArray[i]);
        }
        value = 0;
    return transformArray.size();
    }


}
