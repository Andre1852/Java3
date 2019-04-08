package homework5threads;
//Малыгин Андрей, домашнее задание к 5 уроку Java3.
import java.util.concurrent.CountDownLatch;

public class MainClass {
    public static final int CARS_COUNT = 4;

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int)(Math.random() * 10));
        }


        final CountDownLatch countDownLatch = new CountDownLatch(CARS_COUNT);

        for (int i = 0; i < CARS_COUNT; i++) {
            new Thread(cars[i]).start();
                countDownLatch.countDown();
        }
            try {
                countDownLatch.await();
            } catch (Exception e){
                e.printStackTrace();
            }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}
