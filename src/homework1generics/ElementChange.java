package homework1generics;
//Малыгин Андрей, домашнее задание к 1 уроку Java3.
public class ElementChange {
    static  <T> boolean elementChange (T[] array, int i1, int i2 ){
        if (i1 < 0 || i1 > array.length){
            System.out.println("недопустимое значение параметра i1, замена не произошла");
            return false;
        }
        if (i2 < 0 || i2 > array.length){
            System.out.println("недопустимое значение параметра i2, замена не произошла");
            return false;
        }
        T x = array[i1];
        array[i1] = array[i2];
        array[i2] = x;
        return true;
    }

    public static void main(String[] args) {
        String[] n = {"один", "два", "три", "четыре", "пять", "шесть", "семь"};
        elementChange(n, 0, 5);
        System.out.print("{  ");
        for (String t: n) {
            System.out.print(t + "  ");
        }
        System.out.print("}");
    }
}
