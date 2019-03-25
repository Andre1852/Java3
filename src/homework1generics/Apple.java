package homework1generics;
//Малыгин Андрей, домашнее задание к 1 уроку Java3.
public class Apple extends Fruit {
    private String country;

    public Apple(){
        super("Apple", 1.0f);
        country = "Russia";
    }

    public Apple(String name, float weight, String country) {
        super(name, weight);
        this.country = country;
    }
}
