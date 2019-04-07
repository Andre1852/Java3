package presentation;
// пример взаимоблокирующих потоков
public class Friends {
    private Friends partner;
    private String name;

    public Friends(String name) {
        this.name = name;
    }

    public synchronized void hug(){
        System.out.println(Thread.currentThread().getName() + " в " + name +
                ".hug() пытается вызвать " + partner.name + ".hugBack()");
        partner.hugBack();
    }
    public synchronized void hugBack(){
        System.out.println(Thread.currentThread().getName() + " в " + name +
                ".hugBack()");
    }
    public void becomeFriend(Friends partner){
        this.partner = partner;
    }
    public static void main(String[] args) {
        final Friends leo = new Friends("leo");
        final Friends peter = new Friends("peter");

        leo.becomeFriend(peter);
        peter.becomeFriend(leo);

        new Thread(new Runnable() {
            @Override
            public void run() {
                leo.hug();
            }
        }, "thread1").start();//thread1 владеет блокировкой объекта leo
        //при вызове метода peter.hugBack() thread1 приостанавливает выполнение

        new Thread(new Runnable() {
            @Override
            public void run() {
                peter.hug();
            }
        }, "thread2").start();//thread2 владеет блокировкой объекта peter
        //при вызове метода leo.hugBack() thread2 приостанавливает выполнение
        // потоки программы входят в клинч (могут войти)
    }
}

