package homework4threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);//создается пул потоков
        //способен выполнять задачи в фоновом режиме
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Асинхронная задача");
            }
        });
        executorService.shutdown();//инициирует упорядоченное завершение работы
    }
}
