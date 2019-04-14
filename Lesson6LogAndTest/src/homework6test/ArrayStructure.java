package homework6test;
//Малыгин Андрей, домашнее задание к 6 уроку Java3.
public class ArrayStructure {
    private static int x = 0;
    private static int y = 0;

    public boolean structureCheck(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1){
                x = 1;
            }
            if (arr[i] == 4){
                y = 4;
            }
        }
        if (x == 1 || y == 4){
            x = 0;
            y = 0;
            return true;
        }
        return false;
    }
}
