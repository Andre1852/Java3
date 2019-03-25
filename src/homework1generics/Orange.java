package homework1generics;
//Малыгин Андрей, домашнее задание к 1 уроку Java3.
public class Orange extends Fruit{
    private String size;

    public Orange(){
        super("Orange", 1.5f);
        size = "large";
    }

    public Orange(String name, float weight, String size) {
        super(name, weight);
        this.size = size;
    }
}
