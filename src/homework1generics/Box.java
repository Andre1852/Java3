package homework1generics;
//Малыгин Андрей, домашнее задание к 1 уроку Java3.
import java.util.ArrayList;

public class Box {
    static int sizeappleBox = 48;
    static int sizeorangeBox = 32;

    static <T extends Apple> void appleBox(T[] apple){
        ArrayList appleArrayList = new ArrayList();
        System.out.println("Наполняем ящики яблоками! В одном ящике " + sizeappleBox + " яблок.");
        for (T t: apple) {
            appleArrayList.add(t);
        }
        System.out.println("количество яблок: " + appleArrayList.size());
        System.out.println("количество ящиков яблок: " + appleArrayList.size()/sizeappleBox + " и ещё один ящик не полный");
    }

    static <V extends Orange> void orangeBox(V[] orange){
        ArrayList orangeArrayList = new ArrayList();
        System.out.println("Наполняем ящики апельсинами! В одном ящике " + sizeorangeBox + " апельсинов.");
        for (V t: orange) {
            orangeArrayList.add(t);
        }
        System.out.println("количество апельсинов: " + orangeArrayList.size());
        System.out.println("количество ящиков апельсинов: " + orangeArrayList.size()/sizeorangeBox + " и ещё один ящик не полный");
    }

    static void getWeight(int number, float weight){
        System.out.println("вес ящика: " + number * weight);
    }

    public static void main(String[] args) {
        Apple[] apples = new Apple[250];
        appleBox(apples);

        Orange[] oranges = new Orange[360];
        orangeBox(oranges);

        getWeight(sizeappleBox, 1.0f);
        getWeight(sizeorangeBox, 1.5f);

    }
}
