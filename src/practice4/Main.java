package practice4;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        // Создаем экземпляр нашего SimpleExecutorService с тремя потоками
        ExecutorService executorService = new SimpleExecutorService(3);

        //Создаем и добавляем задачи для выполнения
        for (int i = 0; i < 10; i++) {
            int taskId = i;
            executorService.submit(() -> {
                String threadName = Thread.currentThread().getName();
                System.out.println("Задача " + taskId + " выполняется в потоке " + threadName);
                try {
                    // Имитируем выполнение задачи
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Задача " + taskId + " выполнена");
            });
        }

        // Ждем завершения всех задач
        executorService.shutdown();

        try {
            // Ждем завершения всех задач не более 5 секунд
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                // Если время ожидания истекло, то прерываем выполнение всех задач
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
