
package practice3;
public class Main {
    public static void main(String[] args) {
        // Создаем экземпляр нашей синхронизированной карты
        SynchronizedMap<Integer, String> synchronizedMap = new SynchronizedMap<>();

        // Добавляем элементы в карту из нескольких потоков
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                synchronizedMap.put(i, "Value " + i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 1000; i < 2000; i++) {
                synchronizedMap.put(i, "Value " + i);
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Выводим размер карты
        System.out.println("Size of synchronized map: " + synchronizedMap.size());

        // Выводим содержимое карты
        System.out.println("Contents of synchronized map:");
        for (SynchronizedMap.Entry<Integer, String> entry : synchronizedMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}