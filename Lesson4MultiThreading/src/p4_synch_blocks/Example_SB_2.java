package p4_synch_blocks;

public class Example_SB_2 {

    private Object lock1 = new Object();

    public static void main(String[] args) {
        Example_SB_2 e2 = new Example_SB_2();
        System.out.println("Start");
        new Thread(() -> e2.method1()).start();
        new Thread(() -> e2.method1()).start();
        //два потока хватают 1 метод
    }

    public void method1() {
        System.out.println("Normal part");
        for (int i = 0; i < 3; i++) {
            System.out.println(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        synchronized (lock1) { // можно еще synchronize(this), lock1 - называется заглушка
            //заглушкой может быть только объект (не примитив)
            //возможность доступа к объекту блокируется
            //доступ к блоку кода получает поток первым вызвавший synchronized
            System.out.println("Synch block");
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("M2");
    }
}
