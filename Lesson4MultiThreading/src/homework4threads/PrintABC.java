package homework4threads;
//Малыгин Андрей, домашнее задание к 4 уроку Java3.
public class PrintABC {
    private final Object lock = new Object();// заглушка
    private volatile char letterSymbols = 'A';//изменяемое поле, проверяется перед использованием

    public static void main(String[] args) {
        PrintABC printABC = new PrintABC();
        Thread thread1 = new Thread(() -> {
            printABC.printA();
        });
        Thread thread2 = new Thread(() -> {
            printABC.printB();
        });
        Thread thread3 = new Thread(() -> {
            printABC.printC();
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }

    public void printA(){
        synchronized (lock){
            try{
                for (int i = 0; i < 5; i++){
                    while (letterSymbols != 'A'){
                        lock.wait();
                    }
                    System.out.print("A");
                    letterSymbols = 'B';
                    lock.notifyAll();//активируем все потоки
                }
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void printB(){
        synchronized (lock){
            try{
                for (int i = 0; i < 5; i++){
                    while (letterSymbols != 'B'){
                        lock.wait();
                    }
                    System.out.print("B");
                    letterSymbols = 'C';
                    lock.notifyAll();
                }
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void printC(){
        synchronized (lock){
            try{
                for (int i = 0; i < 5; i++){
                    while (letterSymbols != 'C'){
                        lock.wait();
                    }
                    System.out.print("C");
                    letterSymbols = 'A';
                    lock.notifyAll();
                }
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}
