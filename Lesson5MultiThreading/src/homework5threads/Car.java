package homework5threads;

public class Car implements Runnable {
    private static int CARS_COUNT;
    static {CARS_COUNT = 0;}
    private Race race;
    private int speed;
    private String name;

    public String getName(){
        return name;
    }
    public int getSpeed(){
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");

            MainClass.START.countDown();
            MainClass.START.await();
        } catch (Exception e){
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

        if(MainClass.FINISH.getCount() == MainClass.CARS_COUNT)
            System.out.println(name + " Победил!");
        try {
            MainClass.FINISH.countDown();
            MainClass.FINISH.await();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
