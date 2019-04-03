package homework3io;

import java.io.Serializable;

public class Point implements Serializable {
    private int x;
    private int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return "(" + x + ", " + y + ") ref = " + super.toString();
    }

    public static void main(String[] args) {
        Point point = new Point(5, 16);
        System.out.println(point.toString());
        //всегда используйте геттеры сетеры а на будущее библиотеку lombok
    }




}
