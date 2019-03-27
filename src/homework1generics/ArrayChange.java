package homework1generics;
//Малыгин Андрей, домашнее задание к 1 уроку Java3.
import java.util.ArrayList;

public class ArrayChange {
    static <T>  void arrayChange(T[] arr){
        ArrayList arrayList = new ArrayList();
        System.out.print("получен массив arrayList {  ");
        for (T t: arr) {
            arrayList.add(t);
            System.out.print(t + "  ");
            }
        System.out.println("}");
        System.out.println("количество элементов: " + arrayList.size());
    }

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4};
        arrayChange(array);
    }
}
